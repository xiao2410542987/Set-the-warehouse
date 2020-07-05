package com.storage.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.pojo.Companys;
import com.storage.pojo.Workers;
import com.storage.pojo.Works;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renyu
 * @since 2020-06-04
 */
@Mapper
public interface WorksMapper extends BaseMapper<Works> {

    IPage<Workers> noWork(Page<Workers> workersPage, QueryWrapper<Workers> workersQueryWrapper, int companyid);
    IPage<Workers> haveWork(Page<Workers> workersPage, QueryWrapper<Workers> workersQueryWrapper, int companyid);
    List<Works> workData(int companyid);
    IPage<Workers> workDataOne(Page<Workers> workersPage, QueryWrapper<Workers> workersQueryWrapper, int companyid,String createtime,int state);
    IPage<Workers> workDataOneAll(Page<Workers> workersPage, QueryWrapper<Workers> workersQueryWrapper, int companyid,String createtime);

    //List<Works> workDataOne(Integer state,String createtime);
}
