package com.system.service;

import com.system.entity.HAdmin;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
public interface HAdminService {

    HAdmin load(int id);

    HAdmin get(int id);

    List<HAdmin> findAll();

    void persist(HAdmin entity);

    int save(HAdmin entity);

    void saveOrUpdate(HAdmin entity);

    void delete(int id);

    void flush();

    List<HAdmin> findByHid(int hid);

    HAdmin findByAccount(String account);
}
