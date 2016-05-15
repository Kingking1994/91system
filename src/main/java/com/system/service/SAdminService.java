package com.system.service;

import com.system.entity.SAdmin;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
public interface SAdminService {

    SAdmin load(int id);

    SAdmin get(int id);

    List<SAdmin> findAll();

    void persist(SAdmin entity);

    int save(SAdmin entity);

    void saveOrUpdate(SAdmin entity);

    void delete(int id);

    void flush();
}
