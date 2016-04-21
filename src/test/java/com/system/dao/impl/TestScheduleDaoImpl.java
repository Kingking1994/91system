package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.DoctorDao;
import com.system.dao.ScheduleDao;
import com.system.entity.Schedule;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by king on 2016/4/21.
 */
public class TestScheduleDaoImpl extends GenericTest{

    private static final Logger LOGGER = Logger.getLogger(TestScheduleDaoImpl.class);

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testSave(){


    }

}
