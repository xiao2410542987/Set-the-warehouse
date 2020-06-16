package com.storage.controller;


import com.storage.mapper.WorksMapper;
import com.storage.pojo.Msg;
import com.storage.pojo.Works;
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
    public Msg updWork(@RequestParam @ApiParam(name = "id" ,value = "id") int id,@RequestParam @ApiParam(name = "text" ,value = "工作内容") String text
    ,@RequestParam @ApiParam(name = "companyid" ,value = "所属公司外键") int companyid,@RequestParam @ApiParam(name = "workerid" ,value = "工作人员外键id") int workerid
            ,@RequestParam @ApiParam(name = "goodsid" ,value = "货物订单id,没有就传个0") int goodsid,@RequestParam @ApiParam(name = "distributionid,没有就传个0" ,value = "设备分配外键id") int distributionid
            ,@RequestParam @ApiParam(name = "warehouseid" ,value = "仓库外键id") int warehouseid,@RequestParam @ApiParam(name = "state" ,value = "状态") int state)
    {
        Works works = new Works();
        works.setId(id);
        works.setText(text);
        works.setWorkerid(workerid);
        if (goodsid!=0)
        {
            works.setGoodsid(goodsid);
        }
        if(distributionid!=0)
        {
            works.setDistributionid(distributionid);
        }
        works.setWarehouseid(warehouseid);
        works.setState(state);
        int i = worksMapper.updateById(works);
        if (i==0)
        {
            return Msg.fail().add("tips","修改失败");
        }
        return Msg.success().add("tips","修改成功");
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

