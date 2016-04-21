package com.system.dao.impl;

import com.system.dao.TradeDao;
import com.system.entity.Trade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("tradeDao")
public class TradeDaoImpl implements TradeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Trade load(Integer id) {
        return (Trade)this.getCurrentSession().load(Trade.class,id);
    }

    public Trade get(Integer id) {
        return (Trade)this.getCurrentSession().get(Trade.class,id);
    }

    public List<Trade> findAll() {
        List<Trade> tradeList = this.getCurrentSession().createQuery("from Trade").list();
        return tradeList;
    }

    public void persist(Trade entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Trade entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Trade entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Trade entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
