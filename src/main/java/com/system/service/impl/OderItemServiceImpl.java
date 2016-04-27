package com.system.service.impl;

import com.system.dao.OrderItemDao;
import com.system.entity.OrderItem;
import com.system.service.OrderItemService;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2016/4/26.
 */
@Service("orderItemService")
public class OderItemServiceImpl implements OrderItemService {

    private static final Logger LOGGER = Logger.getLogger(OfficeServiceImpl.class);

    @Autowired
    private OrderItemDao orderItemDao;

    public OrderItem load(String id) {
        LOGGER.info("load id = "+ id);
        if(StrUtil.isBlank(id)){
            return null;
        }else{
            return orderItemDao.load(id);
        }
    }

    public OrderItem get(String id) {
        LOGGER.info("get id = "+ id);
        if(StrUtil.isBlank(id)){
            return null;
        }else{
            return orderItemDao.get(id);
        }
    }

    public List<OrderItem> findAll() {
        LOGGER.info("findAll");
        return orderItemDao.findAll();
    }

    public void persist(OrderItem entity) {
        LOGGER.info("persist entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            orderItemDao.persist(entity);
        }
    }

    public String save(OrderItem entity) {
        LOGGER.info("save entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            return orderItemDao.save(entity);
        }else{
            return null;
        }
    }

    public void saveOrUpdate(OrderItem entity) {
        LOGGER.info("saveOrUpdate entity = " + entity);
        if(BeanUtil.nonNull(entity)){
            orderItemDao.saveOrUpdate(entity);
        }
    }

    public void delete(String id) {
        LOGGER.info("delete id = " + id);
        if(StrUtil.isNotBlank(id)){
            orderItemDao.delete(id);
        }
    }

    public void flush() {
        LOGGER.info("flush");
        orderItemDao.flush();
    }
}
