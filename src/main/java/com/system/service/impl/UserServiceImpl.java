package com.system.service.impl;

import com.system.dao.UserDao;
import com.system.entity.User;
import com.system.service.UserService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public User load(int id) {
        LOGGER.info("load id = "+ id);
        if(id == 0){
            return null;
        }else{
            return userDao.load(id);
        }
    }

    public User get(int id) {
        LOGGER.info("get id = "+ id);
        if(id == 0){
            return null;
        }else{
            return userDao.get(id);
        }
    }

    public List<User> findAll() {
        LOGGER.info("findAll");
        return userDao.findAll();
    }

    public void persist(User entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            userDao.persist(entity);
        }
    }

    public int save(User entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return userDao.save(entity);
        }else{
            return 0;
        }
    }

    public void saveOrUpdate(User entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            userDao.saveOrUpdate(entity);
        }
    }

    public void delete(int id) {
        LOGGER.info("delete id = " + id);
        if(id != 0){
            userDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        userDao.flush();
    }

    public User findByPhone(String phone) {
        LOGGER.info("findByPhone phone = " + phone);
        if(StrUtil.isNotBlank(phone)){
            return userDao.findByPhone(phone);
        }else{
            return null;
        }
    }

    public List<User> findByIdentified(int identified) {
        LOGGER.info("findByIdentified identified = " + identified);
        return userDao.findByIdentified(identified);
    }
}
