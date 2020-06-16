package com.storage.mapper;

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

    List<Workers> noWork(int companyid);
    List<Workers> haveWork(int companyid);
    List<Works> workData();
    List<Works> workDataOne(String createtime);
}
