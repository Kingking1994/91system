package com.system.service.impl;

import com.system.dao.ScheduleDao;
import com.system.entity.Schedule;
import com.system.service.ScheduleService;
import com.system.util.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOGGER = Logger.getLogger(ScheduleServiceImpl.class);

    @Autowired
    private ScheduleDao scheduleDao;

    public Schedule load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return scheduleDao.load(id);
        }
    }

    public Schedule get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return scheduleDao.get(id);
        }
    }

    public List<Schedule> findAll() {
        LOGGER.info("findAll");
        return scheduleDao.findAll();
    }

    public void persist(Schedule entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            scheduleDao.persist(entity);
        }
    }

    public int save(Schedule entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return scheduleDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(Schedule entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            scheduleDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            scheduleDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        scheduleDao.flush();
    }
}
