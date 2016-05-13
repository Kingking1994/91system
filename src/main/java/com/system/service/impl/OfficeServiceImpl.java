package com.system.service.impl;

import com.system.dao.OfficeDao;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.service.OfficeService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("officeService")
public class OfficeServiceImpl implements OfficeService {

    private static final Logger LOGGER = Logger.getLogger(OfficeServiceImpl.class);

    @Autowired
    private OfficeDao officeDao;


    public Office load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return officeDao.load(id);
        }
    }

    public Office get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return officeDao.get(id);
        }
    }

    public List<Office> findAll() {
        LOGGER.info("findAll");
        return officeDao.findAll();
    }

    public void persist(Office entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            officeDao.persist(entity);
        }
    }

    public int save(Office entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return officeDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Office entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            officeDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            officeDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        officeDao.flush();
    }

    public List<Office> findByType(int type) {
        LOGGER.info("findByType type = " + type);
        return officeDao.findByType(type);
    }

    public List<Office> findByLevel(int level) {
        LOGGER.info("findByLevel level = " + level);
        return officeDao.findByLevel(level);
    }

    public Pager<Office> findOffice(Office searchModel, int pageNum, int pageSize) {
        return officeDao.findOffice(searchModel,pageNum,pageSize);
    }
}
