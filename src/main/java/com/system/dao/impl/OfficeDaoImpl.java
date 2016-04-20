package com.system.dao.impl;

import com.system.dao.OfficeDao;
import com.system.entity.Office;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/20.
 */
@Repository("officeDao")
public class OfficeDaoImpl implements OfficeDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public Office load(Integer id) {
        return (Office)this.getCurrentSession().load(Office.class,id);
    }

    public Office get(Integer id) {
        return (Office)this.getCurrentSession().get(Office.class,id);
    }

    public List<Office> findAll() {
        List<Office> officeList = this.getCurrentSession().createQuery("from Office").list();
        return officeList;
    }

    public void persist(Office entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Office entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Office entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Office entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
