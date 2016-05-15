package com.system.dao;

import com.system.entity.HAdmin;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
public interface HAdminDao extends GenericDao<HAdmin,Integer> {

    List<HAdmin> findByHid(int hid);
}
