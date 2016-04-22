package com.system.dao;

import com.system.entity.Doctor;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
public interface DoctorDao extends GenericDao<Doctor,Integer>{

    List<Doctor> findByGender(int gender);

    List<Doctor> findByTitle(int title);
}
