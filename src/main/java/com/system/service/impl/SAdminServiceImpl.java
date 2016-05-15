package com.system.service.impl;

import com.system.dao.SAdminDao;
import com.system.entity.SAdmin;
import com.system.service.SAdminService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
@Service("sAdminService")
public class SAdminServiceImpl implements SAdminService {

    private static final Logger LOGGER = Logger.getLogger(SAdminServiceImpl.class);

    @Autowired
    private SAdminDao sAdminDao;


    public SAdmin load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return sAdminDao.load(id);
        }
    }

    public SAdmin get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return sAdminDao.get(id);
        }
    }

    public List<SAdmin> findAll() {
        LOGGER.info("findAll");
        return sAdminDao.findAll();
    }

    public void persist(SAdmin entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            sAdminDao.persist(entity);
        }
    }

    public int save(SAdmin entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return sAdminDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(SAdmin entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            sAdminDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            sAdminDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        sAdminDao.flush();
    }
}
