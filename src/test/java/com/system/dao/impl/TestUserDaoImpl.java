package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.UserDao;
import com.system.entity.User;
import com.system.entity.UserInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by king on 2016/4/21.
 */
public class TestUserDaoImpl extends GenericTest{

    private static final Logger LOGGER = Logger.getLogger(TestUserDaoImpl.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave(){
        User user = new User("18814122697","123456",0);
        int index = userDao.save(user);
        LOGGER.info("success"+index);
    }

    @Test
    public void testGet(){
        User user = userDao.get(1);
        LOGGER.info(user);
        UserInfo userInfo = user.getUserInfo();
        LOGGER.info(userInfo);
    }

    @Test
    public void testFindByPhone(){
        User user = userDao.findByPhone("18814122697");
        LOGGER.info(user);
    }
}
