package com.system.service.impl;

import com.system.dao.TradeDao;
import com.system.entity.Trade;
import com.system.service.TradeService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("tradeService")
public class TradeServiceImpl implements TradeService {

    private static final Logger LOGGER = Logger.getLogger(TradeServiceImpl.class);

    @Autowired
    private TradeDao tradeDao;

    public Trade load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return tradeDao.load(id);
        }
    }

    public Trade get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return tradeDao.get(id);
        }
    }

    public List<Trade> findAll() {
        LOGGER.info("findAll");
        return tradeDao.findAll();
    }

    public void persist(Trade entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            tradeDao.persist(entity);
        }
    }

    public int save(Trade entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return tradeDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Trade entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            tradeDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            tradeDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        tradeDao.flush();
    }
}
