package com.system.dao;

import com.system.entity.Office;
import com.system.entity.Pager;

import java.util.List;

/**
 * Created by king on 2016/4/20.
 */
public interface OfficeDao extends GenericDao<Office,Integer> {

    List<Office> findByType(int type);

    List<Office> findByLevel(int level);

    Pager<Office> findOffice(Office searchModel,int pageNum,int pageSize);
}
