package com.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.storage.pojo.Companys;
import com.storage.mapper.CompanysMapper;
import com.storage.service.CompanysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@Service
public class CompanysServiceImpl extends ServiceImpl<CompanysMapper, Companys> implements CompanysService {


    @Override
    public List<Companys> list(Companys companys) {
        return list(companys);
    }
}
