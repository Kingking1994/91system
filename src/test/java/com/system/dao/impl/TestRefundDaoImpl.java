package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.OrderItemDao;
import com.system.dao.RefundDao;
import com.system.dao.WalletDao;
import com.system.entity.OrderItem;
import com.system.entity.Refund;
import com.system.entity.Wallet;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
public class TestRefundDaoImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestRefundDaoImpl.class);

    @Autowired
    private WalletDao walletDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private RefundDao refundDao;


    @Test
    public void testSave(){
        Wallet wallet = walletDao.get(1);
        OrderItem orderItem = orderItemDao.get("orderitem1461240435571");

        Refund refund = new Refund(new Timestamp(System.currentTimeMillis()),4,0);

        refund.setOrderItem(orderItem);
        refund.setWid(wallet.getWid());
        refundDao.save(refund);

        wallet.setAccount(wallet.getAccount() + refund.getAmount());
        walletDao.saveOrUpdate(wallet);
    }

    @Test
    public void testGet(){
        Refund refund = refundDao.get(1);
        LOGGER.info(refund);
        OrderItem orderItem = refund.getOrderItem();
        LOGGER.info(orderItem);
    }
}
