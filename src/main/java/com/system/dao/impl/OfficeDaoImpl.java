package com.system.dao.impl;

import com.system.dao.OfficeDao;
import com.system.entity.Office;
import com.system.entity.Pager;
import com.system.util.BeanUtil;
import com.system.util.StrUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by king on 2016/4/20.
 */
@Repository("officeDao")
public class OfficeDaoImpl implements OfficeDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public Office load(Integer id) {
        return (Office)this.getCurrentSession().load(Office.class,id);
    }

    public Office get(Integer id) {
        return (Office)this.getCurrentSession().get(Office.class,id);
    }

    public List<Office> findAll() {
        List<Office> officeList = this.getCurrentSession().createQuery("from Office").list();
        return officeList;
    }

    public void persist(Office entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Office entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Office entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Office entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public List<Office> findByType(int type) {
        String hql = "from Office o where o.type = " + type;
        List<Office> officeList = this.getCurrentSession().createQuery(hql).list();
        return officeList;
    }

    public List<Office> findByLevel(int level) {
        String hql = "from Office o where o.level = " + level;
        List<Office> officeList = this.getCurrentSession().createQuery(hql).list();
        return officeList;
    }


    /**
     * 分页返回查询结果
     * @param searchModel 查询的模型
     * @param pageNum  要显示第几页
     * @param pageSize 每页显示记录条数
     * @return pager
     */
    public Pager<Office> findOffice(Office searchModel, int pageNum, int pageSize) {
        Pager<Office> result = null;

        List officeList = null;

        //存放查询参数
        Map<String,Object> paramMap = new HashMap<String, Object>();

        StringBuilder hql = new StringBuilder("from Office where 1=1");
        StringBuilder countHql = new StringBuilder("select count(oid) from Office where 1=1");

        if(BeanUtil.nonNull(searchModel)){
            String name = searchModel.getName();
            int level= searchModel.getLevel();
            int type = searchModel.getType();
            int hid = searchModel.getHid();

            if(StrUtil.isNotBlank(name)){
                hql.append(" and name like :name");
                countHql.append(" and name like :name");
                paramMap.put("name","%" + name + "%");
            }
            if(level != 0){
                hql.append(" and level = :level");
                countHql.append(" and level = :level");
                paramMap.put("level",level);
            }
            if(type != 0){
                hql.append(" and type = :type");
                countHql.append(" and type = :type");
                paramMap.put("type",type);
            }
            if(hid != 0){
                hql.append(" and hid = :hid");
                countHql.append(" and hid = :hid");
                paramMap.put("hid",hid);
            }
        }

        //查询起始位置
        int fromIndex = pageSize * (pageNum - 1);

        //获得query对象
        Query hqlQuery = this.getCurrentSession().createQuery(hql.toString());
        Query countHqlQuery = this.getCurrentSession().createQuery(countHql.toString());

        setQueryParams(hqlQuery,paramMap);
        setQueryParams(countHqlQuery,paramMap);

        //从第几条记录开始查询
        hqlQuery.setFirstResult(fromIndex);
        //查询多少条记录
        hqlQuery.setMaxResults(pageSize);

        officeList = hqlQuery.list();

        //获得总记录条数
        List<?> countResult = countHqlQuery.list();
        int totalRecord = ((Number)countResult.get(0)).intValue();

        //获得总页数
        int totalPage = totalRecord / pageSize;
        if(totalRecord % pageSize != 0){
            totalPage++;
        }

        //组装result对象
        result = new Pager<Office>(pageSize,pageNum,totalRecord,totalPage,officeList);

        return result;
    }

    /**
     * 设置hql中的查询参数
     * @param query
     * @param paramMap
     * @return
     */
    private Query setQueryParams(Query query, Map<String,Object> paramMap){
        if(paramMap != null && !paramMap.isEmpty()){
            for(Map.Entry<String,Object> entry : paramMap.entrySet()){
                query.setParameter(entry.getKey(),entry.getValue());
            }
        }
        return query;
    }

    public List<Office> findByName(String name) {
        StringBuilder hql = new StringBuilder("from Office where name like :name ");
        Query query = this.getCurrentSession().createQuery(hql.toString());
        query.setParameter("name","%"+name+"%");
        return query.list();
    }
}
