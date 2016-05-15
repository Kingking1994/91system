package com.system.dao.impl;

import com.system.dao.SAdminDao;
import com.system.entity.SAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
@Repository("sAdminDao")
public class SAdminDaoImpl implements SAdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public SAdmin load(Integer id) {
        return (SAdmin)this.getCurrentSession().load(SAdmin.class,id);
    }

    public SAdmin get(Integer id) {
        return (SAdmin)this.getCurrentSession().get(SAdmin.class,id);
    }

    public List<SAdmin> findAll() {
        List<SAdmin> sAdminList = this.getCurrentSession().createQuery("from SAdmin").list();
        return sAdminList;
    }

    public void persist(SAdmin entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(SAdmin entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(SAdmin entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        SAdmin sAdmin = this.load(id);
        this.getCurrentSession().delete(sAdmin);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
