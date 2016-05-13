package com.system.service.impl;

import com.system.dao.HospitalDao;
import com.system.entity.Hospital;
import com.system.entity.Pager;
import com.system.service.HospitalService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/22.
 */
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService{

    private static final Logger LOGGER = Logger.getLogger(HospitalServiceImpl.class);

    @Autowired
    private HospitalDao hospitalDao;

    public Hospital load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return hospitalDao.load(id);
        }
    }

    public Hospital get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return hospitalDao.get(id);
        }
    }

    public List<Hospital> findAll() {
        LOGGER.info("findAll");
        return hospitalDao.findAll();
    }

    public void persist(Hospital entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            hospitalDao.persist(entity);
        }
    }

    public int save(Hospital entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return hospitalDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Hospital entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            hospitalDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            hospitalDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        hospitalDao.flush();
    }

    public List<Hospital> findByQuality(int quality) {
        LOGGER.info("findByQuality quality = " + quality);
        return hospitalDao.findByQuality(quality);
    }

    public List<Hospital> findByRegion(int region) {
        LOGGER.info("findByRegion region = " + region);
        return hospitalDao.findByRegion(region);
    }

    public List<Hospital> findByLevel(int level) {
        LOGGER.info("findByLevel level = " + level);
        return hospitalDao.findByLevel(level);
    }

    public List<Hospital> findByType(int type) {
        LOGGER.info("findByType type = " + type);
        return hospitalDao.findByType(type);
    }

    public Pager<Hospital> findHospital(Hospital searchModel, int pageNum, int pageSize) {
        return hospitalDao.findHospital(searchModel,pageNum,pageSize);
    }

    public List<Hospital> findByName(String name) {
        if(StrUtil.isNotBlank(name)){
            return hospitalDao.findByName(name);
        }
        return null;
    }
}
