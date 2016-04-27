package com.system.service;

import com.system.entity.OrderItem;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
public interface OrderItemService {

    OrderItem load(String id);

    OrderItem get(String id);

    List<OrderItem> findAll();

    void persist(OrderItem entity);

    String save(OrderItem entity);

    void saveOrUpdate(OrderItem entity);

    void delete(String id);

    void flush();
}
