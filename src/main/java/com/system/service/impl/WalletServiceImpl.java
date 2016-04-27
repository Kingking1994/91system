package com.system.service.impl;

import com.system.dao.WalletDao;
import com.system.entity.Wallet;
import com.system.service.WalletService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("walletService")
public class WalletServiceImpl implements WalletService {


    private static final Logger LOGGER = Logger.getLogger(WalletServiceImpl.class);

    @Autowired
    private WalletDao walletDao;

    public Wallet load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return walletDao.load(id);
        }
    }

    public Wallet get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return walletDao.get(id);
        }
    }

    public List<Wallet> findAll() {
        LOGGER.info("findAll");
        return walletDao.findAll();
    }

    public void persist(Wallet entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            walletDao.persist(entity);
        }
    }

    public int save(Wallet entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return walletDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Wallet entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            walletDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            walletDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        walletDao.flush();
    }
}
