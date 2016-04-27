package com.system.service;

import com.system.entity.Schedule;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface ScheduleService {

    Schedule load(int id);

    Schedule get(int id);

    List<Schedule> findAll();

    void persist(Schedule entity);

    int save(Schedule entity);

    void saveOrUpdate(Schedule entity);

    void delete(int id);

    void flush();


}
