package com.system.dao;

import com.system.entity.Hospital;
import com.system.entity.Pager;

import java.util.List;

/**
 * Created by king on 2016/4/20.
 */
public interface HospitalDao extends GenericDao<Hospital,Integer> {

    List<Hospital> findByQuality(int quality);

    List<Hospital> findByRegion(int region);

    List<Hospital> findByLevel(int level);

    List<Hospital> findByType(int type);

    Pager<Hospital> findHospital(Hospital searchModel,int pageNum,int pageSize);
}
