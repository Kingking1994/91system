package com.system.dao.impl;

import com.system.dao.WalletDao;
import com.system.entity.Wallet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("walletDao")
public class WalletDaoImpl implements WalletDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Wallet load(Integer id) {
        return (Wallet)this.getCurrentSession().load(Wallet.class,id);
    }

    public Wallet get(Integer id) {
        return (Wallet)this.getCurrentSession().get(Wallet.class,id);
    }

    public List<Wallet> findAll() {
        List<Wallet> walletList = this.getCurrentSession().createQuery("from Wallet").list();
        return walletList;
    }

    public void persist(Wallet entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Wallet entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Wallet entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Wallet entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
