package com.storage.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.storage.pojo.Distribution;
import com.storage.pojo.Warehouses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.storage.pojo.Workers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface WarehousesMapper extends BaseMapper<Warehouses> {
    Warehouses selectWarehouses(int id);

    IPage<Warehouses> QueryWarehouse(IPage<Warehouses> page, @Param(Constants.WRAPPER) Wrapper<Warehouses> QueryWrapper,int companyid);
}
