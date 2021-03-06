package com.storage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.mapper.GoodsMapper;
import com.storage.mapper.WarehousesMapper;
import com.storage.pojo.Goods;
import com.storage.pojo.Msg;
import com.storage.pojo.Warehouses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/storage/warehouses")
@CrossOrigin
public class WarehousesController {

    @Autowired
    private WarehousesMapper warehousesMapper;

    @Autowired
    private GoodsMapper GoodsMapper;
    @ApiOperation("根据仓库类型查询仓库")
    @RequestMapping(value = "/selectWarehouse", method = RequestMethod.GET)
    public Msg selectWarehouse(
                            @RequestParam @ApiParam(name = "companyid", value = "所属公司\t外键(关联companys   公司表)") int companyid,
                            @RequestParam @ApiParam(name = "warehousetypeid", value = "仓库类型\t外键") int warehousetypeid) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyid",companyid);
        map.put("warehousetypeid",warehousetypeid);
        List<Warehouses> warehouses = warehousesMapper.selectByMap(map);

        return Msg.success().add("tips",warehouses);

    }
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
    public IPage<Warehouses> QueryWarehouse(int start,int state,int companyid){
        Page<Warehouses> page = new Page<>(start, state);
        return warehousesMapper.QueryWarehouse(page,new QueryWrapper<Warehouses>(),companyid);
    }
    @ApiOperation("查询所有仓库(包括可使用)")
    @RequestMapping(value = "/QueryWarehouseAll", method = RequestMethod.GET)
    public IPage<Warehouses> QueryWarehouseAll(int start,int state,int companyid){
        Page<Warehouses> page = new Page<>(start, state);
        return warehousesMapper.QueryWarehouseAll(page,new QueryWrapper<Warehouses>(),companyid);
    }

    @ApiOperation("修改仓库基本信息")
    @RequestMapping(value = "/repairWarehouse", method = RequestMethod.GET)
    public Msg repairWarehouse(@RequestParam @ApiParam(name = "id", value = "仓库id") int id,
                               @RequestParam @ApiParam(name = "name", value = "仓库名字") String name,
                               @RequestParam @ApiParam(name = "waresize", value = "仓库容量") int waresize,
                               @RequestParam @ApiParam(name = "meteringid", value = "数量单位\t外键(关联metering 数量单位类型表)") int meteringid,
                               @RequestParam @ApiParam(name = "unusesize", value = "空闲容量") int unusesize,
                               @RequestParam @ApiParam(name = "warehousetypeid", value = "仓库类型\t外键") int warehousetypeid,
                               @RequestParam @ApiParam(name = "companyid", value = "所属公司\t外键(关联companys   公司表)") int companyid,
                               @RequestParam @ApiParam(name = "workerid", value = "仓库负责人 外键(关联workers 工作人员表)") int workerid
            )

    {
        Warehouses warehouses = new Warehouses();
        warehouses.setId(id);
        warehouses.setCompanyid(companyid);
        warehouses.setWarehousetypeid(warehousetypeid);
        warehouses.setUnusesize(unusesize);
        warehouses.setWaresize(waresize);
        warehouses.setMeteringid(meteringid);
        warehouses.setName(name);
        int updateById = warehousesMapper.updateById(warehouses);
        if (updateById == 1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @ApiOperation("仓库的存量改变")
    @RequestMapping(value = "/stockChange", method = RequestMethod.POST)
    public Msg stockChange(@RequestParam @ApiParam(name = "id", value = "仓库id(要搬走的仓库id)") int id,
                           @RequestParam @ApiParam(name = "unusesize", value = "要搬走的量") int unusesize,
                           @RequestParam @ApiParam(name = "ids", value = "仓库id(要搬进去的仓库id)") int ids,
                           @RequestParam @ApiParam(name = "unusesizes", value = "要搬进去的量") int unusesizes){
        int i = warehousesMapper.stockChange(id, unusesize);
        if(i == 1){
            int i1 = warehousesMapper.stockChangePlus(ids, unusesizes);
            if(i1 == 1){
                return Msg.success();
            }else {
                return Msg.fail();
            }
        }
        return Msg.fail();
    }

    @ApiOperation("确定仓库空闲的余量")
    @RequestMapping(value = "/idle", method = RequestMethod.POST)
    public Msg idle(@RequestParam @ApiParam(name = "id", value = "仓库id") int id,
                    @RequestParam @ApiParam(name = "ids", value = "货物id") int ids){
        Warehouses warehouses = warehousesMapper.selectById(id);
        Goods goods = GoodsMapper.selectById(ids);
        int i = warehouses.getWaresize()-goods.getWeight();
        System.out.println(i);
        if (i> 0){
            Warehouses warehouses1 = new Warehouses();
            warehouses1.setId(id);
            warehouses1.setUnusesize(i);
            int updateById = warehousesMapper.updateById(warehouses1);
            if(updateById == 1){
                return Msg.success();
            }
        }
        return Msg.fail().add("存量错误",i);
    }

}

