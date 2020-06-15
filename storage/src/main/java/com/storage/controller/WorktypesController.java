package com.storage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.storage.mapper.CompanysMapper;
import com.storage.mapper.WorkersMapper;
import com.storage.mapper.WorktypesMapper;
import com.storage.pojo.Companys;
import com.storage.pojo.Msg;
import com.storage.pojo.Workers;
import com.storage.pojo.Worktypes;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private WorktypesMapper worktypesMapper;

    @Autowired
    private WorkersMapper workersMapper;

    @ApiOperation("添加工作类型")
    @RequestMapping(value = "/addworktype",method = RequestMethod.GET)
    public Msg addworktype(@RequestParam @ApiParam(name = "id" ,value = "公司的id") int id
            ,@RequestParam @ApiParam(name = "name" ,value = "工作类别") String name)
    {
        Companys companys = companysMapper.selectById(id);
        HashMap<String, Object> map = new HashMap();
        map.put("companyid",companys.getId());
        map.put("name",name);
        List<Worktypes> type = worktypesMapper.selectByMap(map);
        if (type.size() == 0){
            Worktypes worktypes = new Worktypes();
            worktypes.setName(name);
            worktypes.setCompanyid(companys.getId());
            int insert = worktypesMapper.insert(worktypes);
            if(insert !=0){
                return Msg.success();
            }
        }
        return Msg.fail();
    }


    @ApiOperation("删除工作类型")
    @RequestMapping(value = "/deleteworktype",method = RequestMethod.GET)
    public Msg deleteworktype(@RequestParam @ApiParam(name = "name" ,value = "工作类别id") int id)
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("worktypeid",id);
        List<Workers> workers = workersMapper.selectByMap(map);
        if (workers.size() == 0){
            worktypesMapper.deleteById(id);
            return Msg.success();
        }
        return Msg.fail();
    }

}

