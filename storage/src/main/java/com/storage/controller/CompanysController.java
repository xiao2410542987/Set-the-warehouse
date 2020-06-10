package com.storage.controller;


import com.storage.mapper.CompanysMapper;
import com.storage.pojo.Companys;
import com.storage.pojo.Msg;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("查询所有公司与所有职位")
    @RequestMapping(value = "/selectAllWork",method = RequestMethod.GET)
    public Msg selectAllWork()
    {
        List<Companys> companys = companysMapper.selectAllWork();
        Map map = new HashMap();
        map.put("companys",companys);


        return Msg.success().add("companys",companys);
    }
}

