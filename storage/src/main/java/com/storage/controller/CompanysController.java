package com.storage.controller;


import com.storage.mapper.CompanysMapper;
import com.storage.pojo.Companys;
import com.storage.pojo.Msg;
import com.storage.pojo.Warehouses;
import com.storage.service.CompanysService;
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
@RequestMapping("/storage/companys")
@CrossOrigin
public class CompanysController {

    @Autowired
    private CompanysMapper companysMapper;
    @Autowired
    private CompanysService companysService;

    @ApiOperation("查询所有公司与所有职位")
    @RequestMapping(value = "/selectAllWork",method = RequestMethod.GET)
    public Msg selectAllWork()
    {
        List<Companys> companys = companysMapper.selectAllWork();
        Map map = new HashMap();
        map.put("companys",companys);
        return Msg.success().add("companys",companys);
    }


    @ApiOperation("查询所有公司的名字--回调方法")
    @RequestMapping(value = "/selectAllone",method = RequestMethod.GET)
    public Msg selectAllone()
    {
        return Msg.success().add("name",companysMapper.selectname());
    }

    @ApiOperation("审核公司的信息")
    @RequestMapping(value = "/auditCompany",method = RequestMethod.GET)
    public Msg auditCompany(@RequestParam @ApiParam(name = "id" ,value = "公司id")int id){
        Companys companys = new Companys();
        companys.setId(id);
        companys.setState(1);
        int updateById = companysMapper.updateById(companys);
        if (updateById == 1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @ApiOperation("查询已审核公司的信息")
    @RequestMapping(value = "/selectaudit",method = RequestMethod.GET)
    public Msg audit()
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("state",1);
        return Msg.success().add("message",companysMapper.selectByMap(map));
    }

    @ApiOperation("查询未审核公司的信息")
    @RequestMapping(value = "/selectNaudit",method = RequestMethod.GET)
    public Msg selectNaudit()
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("state",0);
        return Msg.success().add("message",companysMapper.selectByMap(map));
    }

    @ApiOperation("修改公司的信息")
    @RequestMapping(value = "/alterCompany",method = RequestMethod.GET)
    public Msg alterCompany(@RequestParam @ApiParam(name = "id" ,value = "公司id")int id,
                            @RequestParam @ApiParam(name = "name" ,value = "公司名称")String name,
                            @RequestParam @ApiParam(name = "founder" ,value = "公司负责人")String founder,
                            @RequestParam @ApiParam(name = "place" ,value = "公司地址")String place,
                            @RequestParam @ApiParam(name = "phone" ,value = "公司电话")String phone)
    {
        Companys companys = new Companys();
        companys.setId(id);
        companys.setName(name);
        companys.setFounder(founder);
        companys.setPlace(place);
        companys.setPhone(phone);
        int updateById = companysMapper.updateById(companys);
        if(updateById == 1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @ApiOperation("删除公司的信息（伪）")
    @RequestMapping(value = "/deleteAudit",method = RequestMethod.GET)
    public Msg deleteAudit(@RequestParam @ApiParam(name = "id" ,value = "公司id")int id)
    {
        Companys companys = new Companys();
        companys.setId(id);
        companys.setState(2);
        int updateById = companysMapper.updateById(companys);
        if(updateById == 1)return Msg.success();
        return Msg.fail();
    }

    @ApiOperation("查询指定的公司信息")
    @RequestMapping(value = "/selectOne",method = RequestMethod.GET)
    public Msg selectOne(@RequestParam @ApiParam(name = "id" ,value = "公司id")int id)
    {
        Companys companys = companysMapper.selectById(id);
        return Msg.success().add("message",companys);
    }

}

