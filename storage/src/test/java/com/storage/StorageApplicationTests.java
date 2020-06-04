package com.storage;

import com.storage.mapper.CompanysMapper;
import com.storage.pojo.Companys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StorageApplicationTests {

    @Autowired
    private CompanysMapper companysMapper;


    @Test
    void contextLoads() {
	//de
        List<Companys> companys = companysMapper.selectAllWork();
        System.out.println(companys);

    }

}
