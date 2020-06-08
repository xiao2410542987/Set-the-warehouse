package com.storage.controller;


import com.storage.mapper.WorkersMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Workers;
import com.storage.service.impl.WorkersServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
@RequestMapping("/storage/workers")
@CrossOrigin
public class WorkersController {
    @Autowired
    private WorkersMapper workersMapper;

    private WorkersServiceImpl workersService;
    @ApiOperation("员工注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    @ApiImplicitParams(
//            @ApiImplicitParam(name = "name",value = "员工姓名",dataType = "String"),
//            @ApiImplicitParam(name = "sex",value = "员工性别",dataType = "String"),
//            @ApiImplicitParam(name = "phone",value = "员工电话",dataType = "String"),
//            @ApiImplicitParam(name = "password",value = "登录密码",dataType = "String"),
//            @ApiImplicitParam(name = "companyid",value = "所在公司(外键)",dataType = "Integer"),
//            @ApiImplicitParam(name = "worktypeid",value = "员工类型(外键)",dataType = "Integer")
//    )
    public Msg register(@RequestParam @ApiParam(name = "name" ,value = "员工姓名") String name, @RequestParam @ApiParam(name = "sex" ,value = "员工性别") String sex,
                        @RequestParam @ApiParam(name = "phone" ,value = "员工电话") String phone, @RequestParam @ApiParam(name = "password" ,value = "登录密码") String password,
                        @RequestParam @ApiParam(name = "companyid" ,value = "所在公司(外键)") Integer companyid, @RequestParam @ApiParam(name = "worktypeid" ,value = "员工类型(外键)")Integer worktypeid)

    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone",phone);
        List<Workers> workers1 = workersMapper.selectByMap(map);
        if(workers1.size()<1)
        {
            return Msg.fail().add("tips","注册失败:该手机号已被注册");
        }

        return Msg.success().add("tips","注册成功"));
    }

    @ApiOperation("员工登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Map login(@RequestParam @ApiParam(name = "phone" ,value = "员工电话") String phone,@RequestParam @ApiParam(name = "password" ,value = "登录密码") String password){
        Map<Object, Object> map = new HashMap<>();
        Workers workers = new Workers();
        workers.setPhone(phone);
        workers.setPassword(password);
        Workers workers1 = workersMapper.queryWorkersList(workers);
        if(workers1 == null){
            map.put("账号或者密码错误","账号或者密码错误");
        }else {
            map.put("员工姓名",workers1.getName());
            map.put("员工工作单位",workers1.getWorktypes().getName());
        }
        return map;
    }

}

