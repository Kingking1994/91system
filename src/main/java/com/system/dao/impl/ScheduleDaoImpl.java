package com.system.dao.impl;

import com.system.dao.ScheduleDao;
import com.system.entity.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("scheduleDao")
public class ScheduleDaoImpl implements ScheduleDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Schedule load(Integer id) {
        return (Schedule)this.getCurrentSession().load(Schedule.class,id);
    }

    public Schedule get(Integer id) {
        return (Schedule)this.getCurrentSession().get(Schedule.class,id);
    }

    public List<Schedule> findAll() {
        List<Schedule> scheduleList = this.getCurrentSession().createQuery("from Schedule").list();
        return scheduleList;
    }

    public void persist(Schedule entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Schedule entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Schedule entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Schedule entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
