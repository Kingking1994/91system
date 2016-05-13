package com.system.dao.impl;

import com.system.dao.HospitalDao;
import com.system.entity.Hospital;
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
@Repository("hospitalDao")
public class HospitalDaoImpl implements HospitalDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Hospital load(Integer id) {
        return (Hospital)this.getCurrentSession().load(Hospital.class,id);
    }

    public Hospital get(Integer id) {
        return (Hospital)this.getCurrentSession().get(Hospital.class,id);
    }

    public List<Hospital> findAll() {
        List<Hospital> hospitalList = this.getCurrentSession().createQuery("from Hospital").list();
        return hospitalList;
    }

    public void persist(Hospital entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Hospital entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Hospital entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Hospital entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public List<Hospital> findByQuality(int quality) {
        String hql = "from Hospital h where h.quality = " + quality;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByRegion(int region) {
        String hql = "from Hospital h where h.region = " + region;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByLevel(int level) {
        String hql = "from Hospital h where h.level = " + level;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    public List<Hospital> findByType(int type) {
        String hql = "from Hospital h where h.type = " + type;
        List<Hospital> hospitalList = this.getCurrentSession().createQuery(hql).list();
        return hospitalList;
    }

    /**
     * 分页返回查询结果
     * @param searchModel 查询的模型
     * @param pageNum  要显示第几页
     * @param pageSize 每页显示记录条数
     * @return pager
     */
    public Pager<Hospital> findHospital(Hospital searchModel, int pageNum, int pageSize) {
        Pager<Hospital> result = null;

        List hospitalList = null;

        //存放查询参数
        Map<String,Object> paramMap = new HashMap<String, Object>();

        StringBuilder hql = new StringBuilder("from Hospital where 1=1");
        StringBuilder countHql = new StringBuilder("select count(hid) from Hospital where 1=1");

        if(BeanUtil.nonNull(searchModel)){
            String name = searchModel.getName();
            int quality= searchModel.getQuality();
            int level= searchModel.getLevel();
            int region= searchModel.getRegion();
            int type = searchModel.getType();

            if(StrUtil.isNotBlank(name)){
                hql.append(" and name like :name");
                countHql.append(" and name like :name");
                paramMap.put("name","%" + name + "%");
            }
            if(quality != 0){
                hql.append(" and quality = :quality");
                countHql.append(" and quality = :quality");
                paramMap.put("quality",quality);
            }
            if(level != 0){
                hql.append(" and level = :level");
                countHql.append(" and level = :level");
                paramMap.put("level",level);
            }
            if(region != 0){
                hql.append(" and region = :region");
                countHql.append(" and region = :region");
                paramMap.put("region",region);
            }
            if(type != 0){
                hql.append(" and type = :type");
                countHql.append(" and type = :type");
                paramMap.put("type",type);
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

        hospitalList = hqlQuery.list();

        //获得总记录条数
        List<?> countResult = countHqlQuery.list();
        int totalRecord = ((Number)countResult.get(0)).intValue();

        //获得总页数
        int totalPage = totalRecord / pageSize;
        if(totalRecord % pageSize != 0){
            totalPage++;
        }

        //组装result对象
        result = new Pager<Hospital>(pageSize,pageNum,totalRecord,totalPage,hospitalList);

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
}
