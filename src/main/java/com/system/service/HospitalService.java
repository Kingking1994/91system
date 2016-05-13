package com.system.service;

import com.system.entity.Hospital;
import com.system.entity.Pager;

import java.util.List;

/**
 * Created by king on 2016/4/22.
 */
public interface HospitalService {

    Hospital load(int id);

    Hospital get(int id);

    List<Hospital> findAll();

    void persist(Hospital entity);

    int save(Hospital entity);

    void saveOrUpdate(Hospital entity);

    void delete(int id);

    void flush();

    List<Hospital> findByQuality(int quality);

    List<Hospital> findByRegion(int region);

    List<Hospital> findByLevel(int level);

    List<Hospital> findByType(int type);

    Pager<Hospital> findHospital(Hospital searchModel,int pageNum,int pageSize);

    List<Hospital> findByName(String name);
}
