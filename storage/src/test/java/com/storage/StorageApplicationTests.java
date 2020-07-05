package com.storage;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.storage.mapper.*;
import com.storage.pojo.*;
import com.storage.service.impl.EquipmentsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StorageApplicationTests {

//    @Autowired
//    private CompanysMapper companysMapper;
//
//    @Autowired
//    private WorkersMapper workersMapper;

    /*@Autowired
    private EquipmenttypesMapper equipmenttypesMapper;
    @Autowired
    private EquipmenttypesMapper equipmenttypesMapper;*/
    @Autowired
    private WorksMapper worksMapper;

    /*@Autowired
    private WorkersService workersService=new WorkersServiceImpl;*/
//    @Test
//    void contextLoads() {
//	//de
//        List<Companys> companys = companysMapper.selectAllWork();
//        System.out.println(companys);
//
//    }
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
    /*@Test
    public void Test2()
    {
        List<Equipmenttypes> equipmenttypes = equipmenttypesMapper.selectEquipmenttype(1);
        System.out.println(equipmenttypes);
    }*/
   /* @Test
    /*@Test
    public void Test3()
    {
        QueryWrapper<Equipments> queryWrapper = new QueryWrapper<Equipments>();
        queryWrapper.eq("equipmenttypeid",1);
        Equipments equipments = new Equipments();
        equipments.setEquipmenttypeid(0);
        equipmentsMapper.update(equipments,queryWrapper);
    }*/
   /* @Test
    public void Test4()
    {
        Equipments equipments = new Equipments();
        equipments.setId(1);

        equipments.setMeteringid(3);

        equipmentsMapper.updateById(equipments);

    }*/
    /*@Test
    public void Test5()
    {
        Page<Warehouses> page = new Page<>(1, 99);

        IPage<Warehouses> warehousesIPage = warehousesMapper.QueryWarehouse(page, new QueryWrapper<Warehouses>(), 1);
        System.out.println(warehousesIPage);

    }*/
    @Test
    public void  Test6()
    {
        Works works = new Works();
        works.setCompanyid(1);
        works.setDistributionid(null);
        works.setGoodsid(null);
        works.setState(1);
        works.setText("123456");
        works.setWarehouseid(1);
        works.setWorkerid(1);
        int insert = worksMapper.insert(works);
        System.out.println(insert);
    }
}
