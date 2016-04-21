package com.system.dao.impl;

import com.system.dao.OrderItemDao;
import com.system.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by king on 2016/4/21.
 */
@Repository("orderItemDao")
public class OrderItemDaoImpl implements OrderItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public OrderItem load(String id) {
        return (OrderItem)this.getCurrentSession().load(OrderItem.class,id);
    }

    public OrderItem get(String id) {
        return (OrderItem)this.getCurrentSession().get(OrderItem.class,id);
    }

    public List<OrderItem> findAll() {
        List<OrderItem> orderItemList = this.getCurrentSession().createQuery("from OrderItem").list();
        return orderItemList;
    }

    public void persist(OrderItem entity) {
        this.getCurrentSession().persist(entity);
    }

    public String save(OrderItem entity) {
        return (String)this.getCurrentSession().save(generateIdString(entity));
    }

    public void saveOrUpdate(OrderItem entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {
        OrderItem entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }


    /**
     * orderitem主键的生成策略
     * @param entity
     * @return
     */
    private OrderItem generateIdString(OrderItem entity){
        String idString = "orderitem"+entity.getCreated().getTime();
        entity.setOiid(idString);
        return entity;
    }
}
