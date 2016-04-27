package com.system.service;

import com.system.entity.UserInfo;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface UserInfoService {

    UserInfo load(int id);

    UserInfo get(int id);

    List<UserInfo> findAll();

    void persist(UserInfo entity);

    int save(UserInfo entity);

    void saveOrUpdate(UserInfo entity);

    void delete(int id);

    void flush();

    UserInfo findByPhone(String phone);
}
