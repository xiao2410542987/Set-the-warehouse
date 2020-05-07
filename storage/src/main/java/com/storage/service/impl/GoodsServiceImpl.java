package com.storage.service.impl;

import com.storage.pojo.Goods;
import com.storage.mapper.GoodsMapper;
import com.storage.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}
