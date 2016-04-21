package com.system.dao.impl;

import com.system.dao.UserDao;
import com.system.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public User load(Integer id) {
        return (User)this.getCurrentSession().load(User.class,id);
    }

    public User get(Integer id) {
        return (User)this.getCurrentSession().get(User.class,id);
    }

    public List<User> findAll() {
        List<User> userList = this.getCurrentSession().createQuery("from User").list();
        return userList;
    }

    public void persist(User entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(User entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(User entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        User user = this.load(id);
        this.getCurrentSession().delete(user);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
