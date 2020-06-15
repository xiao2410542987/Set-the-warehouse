package com.storage.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.pojo.Workers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
@Mapper
public interface WorkersMapper extends BaseMapper<Workers> {
    Workers queryWorkersList(Workers workers);



    IPage<Workers> audit(IPage<Workers> page, @Param(Constants.WRAPPER) Wrapper<Workers> QueryWrapper,Integer companyid);

    IPage<Workers> checked(Page<Workers> workersPage, QueryWrapper<Workers> workersQueryWrapper, int companyid);
}
