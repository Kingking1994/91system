package com.system.dao.impl;

import com.system.GenericTest;
import com.system.dao.OrderItemDao;
import com.system.dao.TradeDao;
import com.system.dao.WalletDao;
import com.system.entity.OrderItem;
import com.system.entity.Trade;
import com.system.entity.Wallet;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by king on 2016/4/21.
 */
public class TestTradeDaoImpl extends GenericTest {

    private static final Logger LOGGER = Logger.getLogger(TestTradeDaoImpl.class);

    @Autowired
    private TradeDao tradeDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private WalletDao walletDao;

    @Test
    public void testSave(){
        Wallet wallet = walletDao.get(1);
        OrderItem orderItem = orderItemDao.get("orderitem1461240435571");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Trade trade = new Trade(timestamp,4);
        trade.setOrderItem(orderItem);
        trade.setWid(wallet.getWid());
        tradeDao.save(trade);

        wallet.setAccount(wallet.getAccount() - trade.getAmount());
        walletDao.saveOrUpdate(wallet);

        orderItem.setPayed(timestamp);
        orderItemDao.saveOrUpdate(orderItem);
    }

    @Test
    public void testGet(){
        Trade trade = tradeDao.get(1);
        LOGGER.info(trade);
    }
}
