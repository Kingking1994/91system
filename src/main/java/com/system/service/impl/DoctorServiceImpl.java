package com.system.service.impl;

import com.system.dao.DoctorDao;
import com.system.entity.Doctor;
import com.system.entity.Pager;
import com.system.service.DoctorService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {


    private static final Logger LOGGER = Logger.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorDao doctorDao;

    public Doctor load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return doctorDao.load(id);
        }
    }

    public Doctor get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return doctorDao.get(id);
        }
    }

    public List<Doctor> findAll() {
        LOGGER.info("findAll");
        return doctorDao.findAll();
    }

    public void persist(Doctor entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            doctorDao.persist(entity);
        }
    }

    public int save(Doctor entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return doctorDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Doctor entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            doctorDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            doctorDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        doctorDao.flush();
    }

    public List<Doctor> findByGender(int gender) {
        LOGGER.info("findByGender gender = " + gender);
        return doctorDao.findByGender(gender);
    }

    public List<Doctor> findByTitle(int title) {
        LOGGER.info("findByTitle title = " + title);
        return doctorDao.findByTitle(title);
    }

    public Pager<Doctor> findDoctor(Doctor searchModel, int pageNum, int pageSize) {
        return doctorDao.findDoctor(searchModel,pageNum,pageSize);
    }
}
