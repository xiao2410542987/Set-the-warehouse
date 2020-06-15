package com.storage.controller;


import com.storage.mapper.WarehousetypesMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Warehousetypes;
import com.storage.pojo.Workers;
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
@RequestMapping("/storage/warehousetypes")
@CrossOrigin
public class WarehousetypesController {

    @Autowired
    private WarehousetypesMapper warehousetypesMapper;

    @ApiOperation("添加仓库类型")
    @RequestMapping(value = "/AddWarehouseType",method = RequestMethod.GET)
    public Msg AddWarehouseType(@RequestParam @ApiParam(name = "name" ,value = "仓库类型") String name,
            @RequestParam @ApiParam(name = "companyid" ,value = "公司外键id") int companyid){
        Warehousetypes warehousetypes = new Warehousetypes();
        warehousetypes.setName(name);
        warehousetypes.setCompanyid(companyid);
        int insert = warehousetypesMapper.insert(warehousetypes);
        if (insert == 1){
           return Msg.success();
        }
        return Msg.fail();

    }
    @ApiOperation("查询仓库类型")
    @RequestMapping(value = "/selectWarehouseType",method = RequestMethod.POST)
    public Msg selectWarehouseType(@RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("companyid",companyid);
        List<Warehousetypes> warehousetypes = warehousetypesMapper.selectByMap(map);
        return Msg.success().add("tips",warehousetypes);
    }
    @ApiOperation("修改仓库类型")
    @RequestMapping(value = "/updWarehouseType",method = RequestMethod.POST)
    public Msg updWarehouseType(@RequestParam @ApiParam(name = "name" ,value = "仓库类型") String name,@RequestParam @ApiParam(name = "id" ,value = "仓库类型id") int id)
    {
        Warehousetypes warehousetypes = new Warehousetypes();
        warehousetypes.setId(id);
        warehousetypes.setName(name);
        int i = warehousetypesMapper.updateById(warehousetypes);
        if (i == 1){
            return Msg.success().add("tips","修改失败");
        }
        return Msg.fail().add("tips","修改成功");

    }
}

