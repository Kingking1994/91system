package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.OrderItemDao;
import com.system.dao.ScheduleDao;
import com.system.dao.UserInfoDao;
import com.system.entity.OrderItem;
import com.system.entity.Patient;
import com.system.entity.Schedule;
import com.system.entity.UserInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
public class TestOrderItemDaoImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestOrderItemDaoImpl.class);

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSave(){
        Schedule schedule = scheduleDao.get(1);
        UserInfo userInfo = userInfoDao.get(1);


        Patient patient = new Patient("xiaojin",new Date(System.currentTimeMillis()),0,"18814122697");
        OrderItem orderItem = new OrderItem(0,new Time(System.currentTimeMillis()),patient,new Timestamp(System.currentTimeMillis()));
        orderItem.setUiid(userInfo.getUiid());
        orderItem.setSid(schedule.getSid());

        String s = orderItemDao.save(orderItem);

        LOGGER.info(s);
    }


    @Test
    public void testSaveOrUpdate(){
        OrderItem orderItem = orderItemDao.get("orderitem1461240435571");
        orderItem.setPayed(new Timestamp(System.currentTimeMillis()));

        orderItemDao.saveOrUpdate(orderItem);
    }


    @Test
    public void testGet(){
        OrderItem orderItem = orderItemDao.get("orderitem1461240435571");
        LOGGER.info(orderItem);
    }
}
