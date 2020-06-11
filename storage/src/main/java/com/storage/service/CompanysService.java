package com.storage.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.storage.pojo.Companys;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renyu
 * @since 2020-05-07
 */
public interface CompanysService extends IService<Companys> {

    // 查询所有
    List<Companys> list(Companys companys);

}
