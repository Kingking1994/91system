package com.system.service;

import com.system.entity.Wallet;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface WalletService {

    Wallet load(int id);

    Wallet get(int id);

    List<Wallet> findAll();

    void persist(Wallet entity);

    int save(Wallet entity);

    void saveOrUpdate(Wallet entity);

    void delete(int id);

    void flush();
}
