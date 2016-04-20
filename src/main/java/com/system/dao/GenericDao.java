package com.system.dao;

import java.io.Serializable;
import java.util.List;

/**
 * dao通用接口
 * Created by king on 2016/4/20.
 */
public interface GenericDao<T, PK extends Serializable> {

    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();

}

