package com.system.service.impl;

import com.system.dao.RefundDao;
import com.system.entity.Refund;
import com.system.service.RefundService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("refundService")
public class RefundServiceImpl implements RefundService {

    private static final Logger LOGGER = Logger.getLogger(RefundServiceImpl.class);

    @Autowired
    private RefundDao refundDao;

    public Refund load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return refundDao.load(id);
        }
    }

    public Refund get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return refundDao.get(id);
        }
    }

    public List<Refund> findAll() {
        LOGGER.info("findAll");
        return refundDao.findAll();
    }

    public void persist(Refund entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            refundDao.persist(entity);
        }
    }

    public int save(Refund entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return refundDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Refund entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            refundDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            refundDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        refundDao.flush();
    }
}
