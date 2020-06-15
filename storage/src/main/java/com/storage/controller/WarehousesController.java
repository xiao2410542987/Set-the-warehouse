package com.storage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.mapper.WarehousesMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Warehouses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/storage/warehouses")
public class WarehousesController {

    @Autowired
    private WarehousesMapper warehousesMapper;

    @ApiOperation("添加仓库")
    @RequestMapping(value = "/AddWarehouse", method = RequestMethod.GET)
    public Msg AddWarehouse(@RequestParam @ApiParam(name = "name", value = "仓库名字") String name,
                            @RequestParam @ApiParam(name = "waresize", value = "仓库容量") int waresize,
                            @RequestParam @ApiParam(name = "meteringid", value = "数量单位\t外键(关联metering 数量单位类型表)") int meteringid,
                            @RequestParam @ApiParam(name = "unusesize", value = "空闲容量") int unusesize,
                            @RequestParam @ApiParam(name = "warehousetypeid", value = "仓库类型\t外键") int warehousetypeid,
                            @RequestParam @ApiParam(name = "companyid", value = "所属公司\t外键(关联companys   公司表)") int companyid,
                            @RequestParam @ApiParam(name = "workerid", value = "仓库负责人 外键(关联workers 工作人员表)") int workerid) {

        Warehouses warehouses = new Warehouses();
        warehouses.setName(name);
        warehouses.setWaresize(waresize);
        warehouses.setMeteringid(meteringid);
        warehouses.setUnusesize(unusesize);
        warehouses.setWarehousetypeid(warehousetypeid);
        warehouses.setCompanyid(companyid);
        warehouses.setWorkerid(workerid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            warehouses.setCreatetime(df.parse(df.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int insert = warehousesMapper.insert(warehouses);
        if (insert == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @ApiOperation("查询仓库")
    @RequestMapping(value = "/QueryWarehouse", method = RequestMethod.GET)
    public IPage<Warehouses> QueryWarehouse(int start,int state){
        Page<Warehouses> page = new Page<>(start, state);
        return warehousesMapper.QueryWarehouse(page,new QueryWrapper<Warehouses>());
    }


}

