package com.system.dao.impl;

import com.system.dao.DoctorDao;
import com.system.entity.Doctor;
import com.system.entity.Pager;
import com.system.enums.GenderEnum;
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
 * Created by king on 2016/4/21.
 */
@Repository("doctorDao")
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }


    public Doctor load(Integer id) {
        return (Doctor)this.getCurrentSession().load(Doctor.class,id);
    }

    public Doctor get(Integer id) {
        return (Doctor)this.getCurrentSession().get(Doctor.class,id);
    }

    public List<Doctor> findAll() {
        List<Doctor> doctorList = this.getCurrentSession().createQuery("from Doctor").list();
        return doctorList;
    }

    public void persist(Doctor entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(Doctor entity) {
        return (Integer)this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Doctor entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        Doctor entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }

    public List<Doctor> findByGender(int gender) {
        String hql = "from Doctor d where d.gender = " + gender;
        List<Doctor> doctorList = this.getCurrentSession().createQuery(hql).list();
        return doctorList;
    }

    public List<Doctor> findByTitle(int title) {
        String hql = "from Doctor d where d.title = " + title;
        List<Doctor> doctorList = this.getCurrentSession().createQuery(hql).list();
        return doctorList;
    }


    /**
     * 分页返回查询结果
     * @param searchModel 查询的模型
     * @param pageNum  要显示第几页
     * @param pageSize 每页显示记录条数
     * @return pager
     */
    public Pager<Doctor> findDoctor(Doctor searchModel, int pageNum, int pageSize) {
        Pager<Doctor> result = null;

        List doctorList = null;

        //存放查询参数
        Map<String,Object> paramMap = new HashMap<String, Object>();

        StringBuilder hql = new StringBuilder("from Doctor where 1=1");
        StringBuilder countHql = new StringBuilder("select count(did) from Doctor where 1=1");

        if(BeanUtil.nonNull(searchModel)){
            String name = searchModel.getName();
            int gender = searchModel.getGender();
            int title = searchModel.getTitle();

            if(StrUtil.isNotBlank(name)){
                hql.append(" and name like :name");
                countHql.append(" and name like :name");
                paramMap.put("name","%" + name + "%");
            }
            if(gender == GenderEnum.FEMALE.index || gender == GenderEnum.MALE.index){
                hql.append(" and gender = :gender");
                countHql.append(" and gender = :gender");
                paramMap.put("gender",gender);
            }
            if(title != 0){
                hql.append(" and title = :title");
                countHql.append(" and title = :title");
                paramMap.put("title",title);
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

        doctorList = hqlQuery.list();

        //获得总记录条数
        List<?> countResult = countHqlQuery.list();
        int totalRecord = ((Number)countResult.get(0)).intValue();

        //获得总页数
        int totalPage = totalRecord / pageSize;
        if(totalRecord % pageSize != 0){
            totalPage++;
        }

        //组装result对象
        result = new Pager<Doctor>(pageSize,pageNum,totalRecord,totalPage,doctorList);

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
