package com.system.dao.impl;

import com.system.dao.DoctorDao;
import com.system.dao.OfficeDao;
import com.system.entity.Doctor;
import com.system.entity.Office;
import com.system.entity.Schedule;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by king on 2016/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })
public class TestDoctorDaoImpl {

    private static final Logger LOGGER = Logger.getLogger(TestDoctorDaoImpl.class);

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private OfficeDao officeDao;

    @Test
    public void testSave(){

    }


    @Test
    public void testGet(){
        Doctor doctor = doctorDao.get(1);
        LOGGER.info(doctor);
        Set<Schedule> scheduleSet = doctor.getScheduleSet();
        if(!scheduleSet.isEmpty()){
            for(Schedule schedule : scheduleSet){
                LOGGER.info(schedule);
            }
        }
    }
}
