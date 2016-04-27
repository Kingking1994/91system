package com.system.service;

import com.system.entity.Trade;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface TradeService {

    Trade load(int id);

    Trade get(int id);

    List<Trade> findAll();

    void persist(Trade entity);

    int save(Trade entity);

    void saveOrUpdate(Trade entity);

    void delete(int id);

    void flush();
}
