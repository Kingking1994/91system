package com.system.service;

import com.system.entity.Doctor;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface DoctorService {

    Doctor load(int id);

    Doctor get(int id);

    List<Doctor> findAll();

    void persist(Doctor entity);

    int save(Doctor entity);

    void saveOrUpdate(Doctor entity);

    void delete(int id);

    void flush();

    List<Doctor> findByGender(int gender);

    List<Doctor> findByTitle(int title);
}
