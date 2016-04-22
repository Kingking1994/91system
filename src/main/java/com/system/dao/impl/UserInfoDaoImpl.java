package com.system.dao.impl;

import com.system.dao.UserInfoDao;
import com.system.entity.UserInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public UserInfo load(Integer id) {
        return (UserInfo)this.getCurrentSession().load(UserInfo.class,id);
    }

    public UserInfo get(Integer id) {
        return (UserInfo)this.getCurrentSession().get(UserInfo.class,id);
    }

    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = this.getCurrentSession().createQuery("from UserInfo").list();
        return userInfoList;
    }

    public void persist(UserInfo entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(UserInfo entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(UserInfo entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        UserInfo entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public UserInfo findByPhone(String phone) {
        String hql = "from UserInfo ui where ui.phone = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setString(0,phone);
        UserInfo userInfo = (UserInfo)query.uniqueResult();
        return userInfo;
    }
}
