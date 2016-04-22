package com.system.dao;

import com.system.entity.User;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
public interface UserDao extends GenericDao<User,Integer>{

    User findByPhone(String phone);

    List<User> findByIdentified(int identified);
}
