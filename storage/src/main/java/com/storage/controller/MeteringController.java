package com.storage.controller;


import com.storage.mapper.MeteringMapper;
import com.storage.pojo.Metering;
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
@RequestMapping("/storage/metering")
@CrossOrigin
public class MeteringController {
    @Autowired
    private MeteringMapper meteringMapper;

    @ApiOperation("查询计量单位")
    @RequestMapping(value = "/selectMetering",method = RequestMethod.GET)
    public Msg selectMetering(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id") int companyid)
    {
        Map map = new HashMap();
        map.put("companyid",companyid);
        List list = meteringMapper.selectByMap(map);
        if(list.size()==0)
        {
            return Msg.fail().add("tips","查询为空");
        }
        return Msg.success().add("tips",list);

    }
    @ApiOperation("添加计量单位")
    @RequestMapping(value = "/addMetering",method = RequestMethod.GET)
    public Msg addMetering(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id") int companyid,@RequestParam @ApiParam(name = "name" ,value = "计量单位名称") String name)
    {
        Metering metering = new Metering();
        metering.setCompanyid(companyid);
        metering.setName(name);
        int insert = meteringMapper.insert(metering);
        if (insert==0)
        {
            return Msg.fail().add("tips","添加失败");
        }
        return Msg.success().add("tips","添加成功");
    }
    @ApiOperation("修改计量单位")
    @RequestMapping(value = "/updMetering",method = RequestMethod.GET)
    public Msg updMetering(@RequestParam @ApiParam(name = "id" ,value = "id") int id,@RequestParam @ApiParam(name = "name" ,value = "计量单位名称") String name)
    {
        Metering metering = new Metering();
        metering.setId(id);
        metering.setName(name);
        int insert = meteringMapper.updateById(metering);
        if (insert==0)
        {
            return Msg.fail().add("tips","修改失败");
        }
        return Msg.success().add("tips","修改成功");
    }
}

