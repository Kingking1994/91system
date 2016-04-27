package com.system.service;

import com.system.entity.User;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface UserService {

    User load(int id);

    User get(int id);

    List<User> findAll();

    void persist(User entity);

    int save(User entity);

    void saveOrUpdate(User entity);

    void delete(int id);

    void flush();

    User findByPhone(String phone);

    List<User> findByIdentified(int identified);
}
