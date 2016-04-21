package com.system.dao.impl;

import com.system.dao.DoctorDao;
import com.system.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("doctorDao")
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public Doctor load(Integer id) {
        return (Doctor)this.getCurrentSession().load(Doctor.class,id);
    }

    public Doctor get(Integer id) {
        return (Doctor)this.getCurrentSession().get(Doctor.class,id);
    }

    public List<Doctor> findAll() {
        List<Doctor> doctorList = this.getCurrentSession().createQuery("from Doctor").list();
        return doctorList;
    }

    public void persist(Doctor entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Doctor entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Doctor entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Doctor entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
