package com.system.dao.impl;

import com.system.dao.HospitalDao;
import com.system.dao.OfficeDao;
import com.system.entity.Hospital;
import com.system.entity.Office;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by king on 2016/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })
public class TestOfficeDaoImpl {

    private static final Logger LOGGER = Logger.getLogger(TestOfficeDaoImpl.class);

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private HospitalDao hospitalDao;

    @Test
    public void testSave(){

    }
}
