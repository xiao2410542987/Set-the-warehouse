package com.storage.controller;


import com.storage.mapper.CompanysMapper;
import com.storage.mapper.WorkersMapper;
import com.storage.pojo.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renyu
 * @since 2020-05-07 test1
 */
@RestController
@RequestMapping("/storage/worktypes")
public class WorktypesController {
    @Autowired
    private CompanysMapper companysMapper;

    @Autowired
    private WorkersMapper workersMapper;
    @ApiOperation("添加工作类型")
    @RequestMapping(value = "/selectAllone",method = RequestMethod.POST)
    public Msg selectAllone()
    {
        companysMapper.se
        return Msg.success().add("name",companysMapper.selectname());
    }
}

