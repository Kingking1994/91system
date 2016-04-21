package com.system.dao.impl;

import com.system.dao.HospitalDao;
import com.system.dao.OfficeDao;
import com.system.entity.Doctor;
import com.system.entity.Hospital;
import com.system.entity.Office;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by king on 2016/4/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })
public class TestHospitalDaoImpl {

    private static final Logger LOGGER = Logger.getLogger(TestHospitalDaoImpl.class);

    @Autowired
    private HospitalDao hospitalDao;


    @Test
    public void testSave(){
        String name = "华工大医院";
        String address= "华南理工大学";
        String telephone = "123456789";
        Hospital entity = new Hospital(name,address,telephone);
        int index = hospitalDao.save(entity);
        LOGGER.info("成功保存"+index);
    }

    @Test
    public void testFindAll(){
        List<Hospital> hospitalList = hospitalDao.findAll();
        for(Hospital hospital : hospitalList){
            LOGGER.info(hospital);
        }
    }

    @Test
    public void testGet(){
        Hospital hospital = hospitalDao.get(1);
        LOGGER.info(hospital);
        Set<Office> officeSet = hospital.getOfficeSet();
        if (!officeSet.isEmpty()){
            for(Office office : officeSet){
                LOGGER.info(office);

            }
        }
    }
}
