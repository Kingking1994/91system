package com.system.service.impl;

import com.system.dao.HAdminDao;
import com.system.entity.HAdmin;
import com.system.service.HAdminService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
@Service("hAdminService")
public class HAdminServiceImpl implements HAdminService {

    private static final Logger LOGGER = Logger.getLogger(HAdminServiceImpl.class);

    @Autowired
    private HAdminDao hAdminDao;

    public HAdmin load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return hAdminDao.load(id);
        }
    }

    public HAdmin get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return hAdminDao.get(id);
        }
    }

    public List<HAdmin> findAll() {
        LOGGER.info("findAll");
        return hAdminDao.findAll();
    }

    public void persist(HAdmin entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            hAdminDao.persist(entity);
        }
    }

    public int save(HAdmin entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return hAdminDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(HAdmin entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            hAdminDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            hAdminDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        hAdminDao.flush();
    }

    public List<HAdmin> findByHid(int hid) {
        LOGGER.info("findByHid id = "+ hid);
        if(hid == 0){
            return null;
        }else{
            return hAdminDao.findByHid(hid);
        }
    }

    public HAdmin findByAccount(String account) {
        LOGGER.info("account = "+ account);
        if(StrUtil.isBlank(account)){
            return null;
        }
        return hAdminDao.findByAccount(account);
    }
}
