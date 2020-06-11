package com.storage;


import com.storage.mapper.CompanysMapper;
import com.storage.mapper.WorkersMapper;
import com.storage.pojo.Companys;
import com.storage.pojo.Workers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StorageApplicationTests {

    @Autowired
    private CompanysMapper companysMapper;

    @Autowired
    private WorkersMapper workersMapper;

    /*@Autowired
    private WorkersService workersService=new WorkersServiceImpl;*/
    @Test
    void contextLoads() {
	//de
        List<Companys> companys = companysMapper.selectAllWork();
        System.out.println(companys);

    }
    /*@Test
    public void login(){
        Workers workers = new Workers();
        workers.setPhone("12345678900");
        workers.setPassword("123");
        System.out.println(workersMapper.queryWorkersList(workers));
    }
    @Test
    public void Test1()
    {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone","12345678900");
        List<Workers> workers1 = workersMapper.selectByMap(map);
        System.out.println(workers1);
    }*/

}
