package com.storage.controller;


import com.storage.mapper.WarehousetypesMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Warehousetypes;
import com.storage.pojo.Workers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

