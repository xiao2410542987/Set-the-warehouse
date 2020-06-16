package com.storage.controller;


import com.storage.mapper.WorksMapper;
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
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/storage/works")
@CrossOrigin
public class WorksController {
    @Autowired
    private WorksMapper worksMapper;

    @ApiOperation("修改任务")
    @RequestMapping(value = "/updWork",method = RequestMethod.POST)
    public Msg updWork(@RequestParam @ApiParam(name = "companyid" ,value = "所属公司外键") int companyid)
    {
        return Msg.success();
    }
    @ApiOperation("删除任务")
    @RequestMapping(value = "/delWork",method = RequestMethod.POST)
    public Msg delWork(@RequestParam @ApiParam(name = "id" ,value = "id") int id)
    {
        int i = worksMapper.deleteById(6);
        if(i==0)
        {
            return Msg.fail().add("tips","删除失败");
        }
        return Msg.success().add("tips","删除成功");
    }

}

