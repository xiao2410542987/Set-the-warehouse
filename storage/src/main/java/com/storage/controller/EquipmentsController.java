package com.storage.controller;


import com.storage.mapper.EquipmentsMapper;
import com.storage.pojo.Equipments;
import com.storage.pojo.Msg;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/storage/equipments")
@CrossOrigin
public class EquipmentsController {
    @Autowired
    private EquipmentsMapper equipmentsMapper;

    @ApiOperation("修改设备数量或单位")
    @RequestMapping(value = "/updEquipment",method = RequestMethod.POST)
    public Msg updEquipment(@RequestParam @ApiParam(name = "id" ,value = "设备id") int id,@RequestParam @ApiParam(name = "equipmenttypeid" ,value = "设备类型id") int equipmenttypeid,
                       @RequestParam @ApiParam(name = "number" ,value = "设备总数") int number,@RequestParam @ApiParam(name = "unuse" ,value = "未使用的数量") int unuse,
                       @RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid,@RequestParam @ApiParam(name = "meteringid" ,value = "计量单位id") int meteringid)
    {
        Equipments equipments = new Equipments();
        equipments.setId(id);
        equipments.setEquipmenttypeid(equipmenttypeid);
        equipments.setNumber(number);
        equipments.setUnuse(unuse);
        equipments.setCompanyid(companyid);
        equipments.setMeteringid(meteringid);
        int i = equipmentsMapper.updateById(equipments);
        if(i==0)
        {
            return Msg.fail().add("tips","修改失败");
        }
        return Msg.success().add("tips","修改成功");
    }
}

