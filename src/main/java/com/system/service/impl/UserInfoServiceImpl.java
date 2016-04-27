package com.system.service.impl;

import com.system.dao.UserInfoDao;
import com.system.entity.UserInfo;
import com.system.service.UserInfoService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return userInfoDao.load(id);
        }
    }

    public UserInfo get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return userInfoDao.get(id);
        }
    }

    public List<UserInfo> findAll() {
        LOGGER.info("findAll");
        return userInfoDao.findAll();
    }

    public void persist(UserInfo entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            userInfoDao.persist(entity);
        }
    }

    public int save(UserInfo entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return userInfoDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(UserInfo entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            userInfoDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            userInfoDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        userInfoDao.flush();
    }

    public UserInfo findByPhone(String phone) {
        LOGGER.info("findByPhone phone = " + phone);
        if(StrUtil.isNotBlank(phone)){
            return userInfoDao.findByPhone(phone);
        }else{
            return null;
        }
    }
}
