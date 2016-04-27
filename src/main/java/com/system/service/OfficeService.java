package com.system.service;

import com.system.entity.Office;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface OfficeService {

    Office load(int id);

    Office get(int id);

    List<Office> findAll();

    void persist(Office entity);

    int save(Office entity);

    void saveOrUpdate(Office entity);

    void delete(int id);

    void flush();

    List<Office> findByType(int type);

    List<Office> findByLevel(int level);
}
