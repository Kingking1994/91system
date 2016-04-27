package com.system.service;

import com.system.entity.Refund;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface RefundService {

    Refund load(int id);

    Refund get(int id);

    List<Refund> findAll();

    void persist(Refund entity);

    int save(Refund entity);

    void saveOrUpdate(Refund entity);

    void delete(int id);

    void flush();
}
