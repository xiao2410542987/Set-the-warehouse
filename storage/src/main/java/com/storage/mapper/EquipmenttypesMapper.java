package com.storage.mapper;

import com.storage.pojo.Companys;
import com.storage.pojo.Equipmenttypes;
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
public interface EquipmenttypesMapper extends BaseMapper<Equipmenttypes> {
    List<Equipmenttypes> selectEquipmenttype(int companyid);


}
