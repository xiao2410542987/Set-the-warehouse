package com.storage.controller;


import com.storage.mapper.EquipmentsMapper;
import com.storage.mapper.EquipmenttypesMapper;
import com.storage.pojo.Equipments;
import com.storage.pojo.Equipmenttypes;
import com.storage.pojo.Msg;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/storage/equipmenttypes")
@CrossOrigin
public class EquipmenttypesController {

    @Autowired
    private EquipmenttypesMapper equipmenttypesMapper;
    @Autowired
    private EquipmentsMapper equipmentsMapper;
    @ApiOperation("查询设备类型")
    @RequestMapping(value = "/selectEquipmenttypes",method = RequestMethod.GET)
    public Msg selectEquipmenttype(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id") int companyid)
    {
        List<Equipmenttypes> equipmenttypes = equipmenttypesMapper.selectEquipmenttype(companyid);
        System.out.println(equipmenttypes);

        return Msg.success().add("tips",equipmenttypes);
    }


    @ApiOperation("添加新设备类型")
    @RequestMapping(value = "/addEquipmenttype",method = RequestMethod.GET)
    public Msg addEquipmenttype(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id") int companyid,@RequestParam @ApiParam(name = "name" ,value = "新设备名称") String name,
                                @RequestParam @ApiParam(name = "meteringid" ,value = "新设备名称") int meteringid)
    {
        Equipmenttypes equipmenttypes = new Equipmenttypes();


        equipmenttypes.setCompanyid(companyid);
        equipmenttypes.setName(name);
        Map map = new HashMap();
        map.put("companyid",companyid);
        map.put("name",name);
        List list = equipmenttypesMapper.selectByMap(map);

        if (list.size()>0)
        {
            return Msg.fail().add("tips","该设备已存在");
        }

        int insert = equipmenttypesMapper.insert(equipmenttypes);


        if (insert==0)
        {
            return Msg.fail().add("tips","添加失败");
        }
        List<Equipmenttypes> list1 = equipmenttypesMapper.selectByMap(map);
        Integer companyid1 = list1.get(0).getCompanyid();
        Equipments equipments = new Equipments();
        equipments.setEquipmenttypeid(companyid1);
        equipments.setNumber(0);
        equipments.setUnuse(0);
        equipments.setCompanyid(companyid);
        equipments.setMeteringid(meteringid);
        int insert1 = equipmentsMapper.insert(equipments);
        return Msg.success().add("tips","添加成功");

    }

/*    @ApiOperation("删除设备类型")
    @RequestMapping(value = "/delEquipmenttype",method = RequestMethod.GET)
    public Msg delEquipmenttype(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id") int companyid,@RequestParam @ApiParam(name = "id" ,value = "设备id") int id) {
        Map map = new HashMap();
        map.put("equipmenttypeid",id);
        Equipments equipments = new Equipments();
        equipments.setEquipmenttypeid(id);

        int i1 = equipmentsMapper.update();
        if (i==0)
        {
            return Msg.fail().add("tips","该设备正在被回收");
        }
        int i = equipmenttypesMapper.deleteById(id);

    }*/


}

