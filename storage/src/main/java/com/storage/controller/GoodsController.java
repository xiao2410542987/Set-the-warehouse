package com.storage.controller;


import com.storage.mapper.GoodsMapper;
import com.storage.pojo.Goods;
import com.storage.pojo.Msg;
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
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/storage/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @ApiOperation("提交新订单")
    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public Msg addGoods(@RequestParam @ApiParam(name = "goodsname" ,value = "订单物品名称") String goodsname, @RequestParam @ApiParam(name = "weight" ,value = "重量") int weight,
                            @RequestParam @ApiParam(name = "meteringid" ,value = "数量单位") int meteringid, @RequestParam @ApiParam(name = "username" ,value = "客户名称") String username,
                            @RequestParam @ApiParam(name = "userphone" ,value = "客户电话") String userphone, @RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid,
                            @RequestParam @ApiParam(name = "warehouseid" ,value = "仓库位置") int warehouseid, @RequestParam @ApiParam(name = "state" ,value = "订单状态") int state)
    {
        Goods goods = new Goods();
        goods.setGoodsname(goodsname);
        goods.setWeight(weight);
        goods.setMeteringid(meteringid);
        goods.setUsername(username);
        goods.setUserphone(userphone);
        goods.setCompanyid(companyid);
        goods.setWarehouseid(warehouseid);
        goods.setState(state);

        int i = goodsMapper.insert(goods);
        if(i==0)
        {
            return Msg.fail().add("tips","添加失败");
        }
        return Msg.success().add("tips","添加成功");
    }

    @ApiOperation("修改订单")
    @RequestMapping(value = "/updGoods",method = RequestMethod.POST)
    public Msg updGoods(@RequestParam @ApiParam(name = "id" ,value = "id") int id,
            @RequestParam @ApiParam(name = "goodsname" ,value = "订单物品名称") String goodsname, @RequestParam @ApiParam(name = "weight" ,value = "重量") int weight,
                            @RequestParam @ApiParam(name = "meteringid" ,value = "数量单位") int meteringid, @RequestParam @ApiParam(name = "username" ,value = "客户名称") String username,
                            @RequestParam @ApiParam(name = "userphone" ,value = "客户电话") String userphone, @RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid,
                            @RequestParam @ApiParam(name = "warehouseid" ,value = "仓库位置") int warehouseid, @RequestParam @ApiParam(name = "state" ,value = "订单状态") int state)
    {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setGoodsname(goodsname);
        goods.setWeight(weight);
        goods.setMeteringid(meteringid);
        goods.setUsername(username);
        goods.setUserphone(userphone);
        goods.setCompanyid(companyid);
        goods.setWarehouseid(warehouseid);
        goods.setState(state);

        int i = goodsMapper.updateById(goods);
        if(i==0)
        {
            return Msg.fail().add("tips","修改失败");
        }
        return Msg.success().add("tips","修失败成功");
    }
    @ApiOperation("查询订单")
    @RequestMapping(value = "/selectGoods",method = RequestMethod.POST)
    public Msg selectGoods(@RequestParam @ApiParam(name = "companyid" ,value = "公司id") int companyid)
    {
        List<Goods> goods = goodsMapper.selectAllGoods(companyid);

        return Msg.success().add("tips",goods);

    }

}

