package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.UserInfoDao;
import com.system.dao.WalletDao;
import com.system.entity.Wallet;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
public class TestWalletDaoImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestWalletDaoImpl.class);

    @Autowired
    private WalletDao walletDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSave(){
        Wallet wallet = new Wallet(100);
        wallet.setUserInfo(userInfoDao.get(1));
        walletDao.save(wallet);
    }

    @Test
    public void testGet(){
        Wallet wallet = walletDao.get(1);
        LOGGER.info(wallet);
    }


}
