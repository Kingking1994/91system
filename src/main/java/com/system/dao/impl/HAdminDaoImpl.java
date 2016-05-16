package com.system.dao.impl;

import com.system.dao.HAdminDao;
import com.system.entity.HAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/5/15.
 */
@Repository("hAdminDao")
public class HAdminDaoImpl implements HAdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public List<HAdmin> findByHid(int hid) {
        StringBuilder hql = new StringBuilder("from HAdmin where hid = "+hid);
        return this.getCurrentSession().createQuery(hql.toString()).list();
    }

    public HAdmin load(Integer id) {
        return (HAdmin)this.getCurrentSession().load(HAdmin.class,id);
    }

    public HAdmin get(Integer id) {
        return (HAdmin)this.getCurrentSession().get(HAdmin.class,id);
    }

    public List<HAdmin> findAll() {
        StringBuilder hql = new StringBuilder("from HAdmin");
        List<HAdmin> hAdminList = this.getCurrentSession().createQuery(hql.toString()).list();
        return hAdminList;
    }

    public void persist(HAdmin entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(HAdmin entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(HAdmin entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        HAdmin hAdmin = this.load(id);
        this.getCurrentSession().delete(hAdmin);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public HAdmin findByAccount(String account) {
        StringBuilder hql = new StringBuilder("from HAdmin where account = "+ account);
        HAdmin hAdmin = (HAdmin)this.getCurrentSession().createQuery(hql.toString()).uniqueResult();
        return hAdmin;
    }
}
