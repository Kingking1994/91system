package com.system.dao.impl;

import com.system.dao.RefundDao;
import com.system.entity.Refund;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("refundDao")
public class RefundDaoImpl implements RefundDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public Refund load(Integer id) {
        return (Refund)this.getCurrentSession().load(Refund.class,id);
    }

    public Refund get(Integer id) {
        return (Refund)this.getCurrentSession().get(Refund.class,id);
    }

    public List<Refund> findAll() {
        List<Refund> refundList = this.getCurrentSession().createQuery("from Refund").list();
        return refundList;
    }

    public void persist(Refund entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Refund entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Refund entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Refund entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
