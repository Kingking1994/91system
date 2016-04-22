package com.system.dao.impl;

import com.system.dao.HospitalDao;
import com.system.entity.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/20.
 */
@Repository("hospitalDao")
public class HospitalDaoImpl implements HospitalDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Hospital load(Integer id) {
        return (Hospital)this.getCurrentSession().load(Hospital.class,id);
    }

    public Hospital get(Integer id) {
        return (Hospital)this.getCurrentSession().get(Hospital.class,id);
    }

    public List<Hospital> findAll() {
        List<Hospital> hospitalList = this.getCurrentSession().createQuery("from Hospital").list();
        return hospitalList;
    }

    public void persist(Hospital entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Hospital entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Hospital entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Hospital entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public List<Hospital> findByQuality(int quality) {
        String hql = "from Hospital h where h.quality = " + quality;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByRegion(int region) {
        String hql = "from Hospital h where h.region = " + region;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByLevel(int level) {
        String hql = "from Hospital h where h.level = " + level;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByType(int type) {
        String hql = "from Hospital h where h.type = " + type;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }
}
