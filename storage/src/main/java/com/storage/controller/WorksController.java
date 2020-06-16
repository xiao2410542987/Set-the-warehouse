package com.storage.controller;


import com.storage.mapper.WorkersMapper;
import com.storage.mapper.WorksMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Workers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author renyu
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/storage/works")
@CrossOrigin
public class WorksController {

    @Autowired
    private WorksMapper worksMapper;

    @ApiOperation("查询没有分配工作的员工")
    @RequestMapping(value = "/noWork",method = RequestMethod.GET)
    public Msg noWork(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id(外键)") int companyid){
        List<Workers> workers = worksMapper.noWork(companyid);
        return Msg.success().add("work",workers);
    }

    @ApiOperation("查询已分配工作的员工")
    @RequestMapping(value = "/haveWork",method = RequestMethod.GET)
    public Msg haveWork(@RequestParam @ApiParam(name = "companyid" ,value = "公司的id(外键)") int companyid){
        List<Workers> workers = worksMapper.haveWork(companyid);
        return Msg.success().add("work",workers);
    }

    @ApiOperation("查询工作任务的日期")
    @RequestMapping(value = "/workData",method = RequestMethod.GET)
    public Msg workData(){
        return Msg.success().add("data",worksMapper.workData());
    }

    @ApiOperation("根据日期查询工作任务(未完成)")
    @RequestMapping(value = "/workDataOne",method = RequestMethod.GET)
    public Msg workDataOne(@RequestParam @ApiParam(name = "createtime" ,value = "日期格式（例20200601）") String createtime){
        return Msg.success().add("data",worksMapper.workDataOne(createtime));
    }
}

