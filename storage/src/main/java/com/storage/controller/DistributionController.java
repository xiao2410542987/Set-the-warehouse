package com.storage.controller;


import com.storage.mapper.DistributionMapper;
import com.storage.mapper.EquipmentsMapper;
import com.storage.pojo.Distribution;
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
@RequestMapping("/storage/distribution")
@CrossOrigin
public class DistributionController {

    @Autowired
    private DistributionMapper distributionMapper;

    @ApiOperation("分配新设备")
    @RequestMapping(value = "/addDis",method = RequestMethod.POST)
    public Msg addDis( @RequestParam @ApiParam(name = "state" ,value = "状态") int state,
                       @RequestParam @ApiParam(name = "warehouseid" ,value = "仓库外键id") int warehouseid, @RequestParam @ApiParam(name = "equipmentid" ,value = "设备数量外键id") int equipmentid,
                       @RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid, @RequestParam @ApiParam(name = "name" ,value = "名称") String name)
    {
        Distribution distribution = new Distribution();
        distribution.setState(state);
        distribution.setWarehouseid(warehouseid);
        distribution.setEquipmentid(equipmentid);
        distribution.setCompanyid(companyid);
        distribution.setName(name);
        int i = distributionMapper.insert(distribution);
        if(i==0)
        {
            return Msg.fail().add("tips","添加失败");
        }
        return Msg.success().add("tips","添加成功");
    }
    @ApiOperation("回收设备分配")
    @RequestMapping(value = "/delDis",method = RequestMethod.POST)
    public Msg delDis( @RequestParam @ApiParam(name = "state" ,value = "状态") int state, @RequestParam @ApiParam(name = "id" ,value = "id") int id
                       )
    {
        Distribution distribution = new Distribution();
        distribution.setId(id);
        distribution.setState(state);
        int i = distributionMapper.updateById(distribution);
        if(i==0)
        {
            return Msg.fail().add("tips","删除失败");
        }
        return Msg.success().add("tips","删除成功");
    }

    @ApiOperation("修改设备分配")
    @RequestMapping(value = "/updDis",method = RequestMethod.POST)
    public Msg updDis(@RequestParam @ApiParam(name = "id" ,value = "设备id") int id, @RequestParam @ApiParam(name = "state" ,value = "状态") int state,
                       @RequestParam @ApiParam(name = "warehouseid" ,value = "仓库外键id") int warehouseid, @RequestParam @ApiParam(name = "equipmentid" ,value = "设备数量外键id") int equipmentid,
                       @RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid, @RequestParam @ApiParam(name = "name" ,value = "名称") String name)
    {
        Distribution distribution = new Distribution();
        distribution.setId(id);
        distribution.setState(state);
        distribution.setWarehouseid(warehouseid);
        distribution.setEquipmentid(equipmentid);
        distribution.setCompanyid(companyid);
        distribution.setName(name);
        int i = distributionMapper.updateById(distribution);
        if(i==0)
        {
            return Msg.fail().add("tips","修改失败");
        }
        return Msg.success().add("tips","修改成功");
    }
}

