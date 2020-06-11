package com.storage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.mapper.WorkersMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Workers;

import com.storage.service.impl.WorkersServiceImpl;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

<<<<<<< HEAD

=======
>>>>>>> 5c8b5e71ff8e756a6e87de8c9b605af095b2bbb4
    @ApiOperation("员工注册")
    @RequestMapping(value = "/register",method = RequestMethod.GET)
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
                        @RequestParam @ApiParam(name = "companyid" ,value = "所在公司(外键)") Integer companyid, @RequestParam @ApiParam(name = "worktypeid" ,value = "员工类型(外键)")Integer worktypeid,
                        HttpServletRequest request,HttpSession session,HttpServletResponse response)

    {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//设置允许跨域请求地址即为当前请求地址
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");//允许服务器向浏览器跨域响应时更改浏览器（客户端）的cookie
        response.setHeader("XDomainRequestAllowed","1");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone",phone);
        List<Workers> workers1 = workersMapper.selectByMap(map);
        if(workers1.size()>0)
        {
            return Msg.fail().add("tips","注册失败:该手机号已被注册");
        }

        Workers workers = new Workers();
        workers.setCompanyid(companyid);
        workers.setPhone(phone);
        workers.setPassword(password);
        workers.setName(name);
        workers.setSex(sex);
        workers.setWorktypeid(worktypeid);
        workersMapper.insert(workers);

        return Msg.success().add("tips","注册成功");
    }

    @ApiOperation("员工登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Msg login(@RequestParam @ApiParam(name = "phone" ,value = "员工电话") String phone,
                     @RequestParam @ApiParam(name = "password" ,value = "登录密码") String password,
                     HttpServletRequest request,HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//设置允许跨域请求地址即为当前请求地址
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");//允许服务器向浏览器跨域响应时更改浏览器（客户端）的cookie
        response.setHeader("XDomainRequestAllowed","1");
        Workers workers = new Workers();
        workers.setPhone(phone);
        workers.setPassword(password);
        Workers workers1 = workersMapper.queryWorkersList(workers);
        if(workers1 == null){
           return Msg.fail().add("账号或者密码错误","账号或者密码错误");
        }else {
            //session.setAttribute("login",workers1.getWorktypes().getName());
            request.getSession().setAttribute("login",workers1.getWorktypes().getName());
            System.out.println(session.getAttribute("login"));
            return Msg.success().add("员工姓名",workers1.getName()).add("员工工作单位",workers1.getWorktypes().getName());
        }

    }

    @ApiOperation("开除员工")
    @RequestMapping(value = "/dismiss",method = RequestMethod.GET)
    public Msg dismiss(@RequestParam @ApiParam(name = "id" ,value = "员工id") int id)
    {
        Workers workers = new Workers();
        workers.setId(5);
        workers.setState(2);
        int updateById = workersMapper.updateById(workers);
        QueryWrapper<Workers> workersQueryWrapper = new QueryWrapper<Workers>();
        workersQueryWrapper.eq("state",2);
        int update = workersMapper.update(workers, workersQueryWrapper);
        if(updateById == 1){
            return Msg.success();
        }
        return Msg.fail();
    }

    @ApiOperation("查询未审核的员工")
    @RequestMapping(value = "/audit",method = RequestMethod.GET)
    public IPage<Workers> audit(Page<Workers> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return workersMapper.audit(page,state);
    }
}

