package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.UserDao;
import com.system.dao.UserInfoDao;
import com.system.entity.User;
import com.system.entity.UserInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by king on 2016/4/21.
 */
public class TestUserInfoDaoImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestUserInfoDaoImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserDao userDao;


    @Test
    public void testSave(){
        User user = userDao.get(1);
        Date birthday = new Date(System.currentTimeMillis());
        UserInfo userInfo = new UserInfo(user.getPhone(),"肖劲",0,birthday,"12345678910");
        userInfo.setUser(user);

        userInfoDao.save(userInfo);
    }
}
