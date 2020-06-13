package com.storage.mapper;

import com.storage.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
        List<Goods> selectAllGoods(int companyid);
}
