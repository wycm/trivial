package com.blog.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wy on 2016/6/5 0005.
 */
@Repository
@Transactional
public class BaseDAO<T> {
//    private Logger log = Logger.getLogger(getClass());
    @Autowired
    private SessionFactory sessionFactory;
    protected Class<T> entity;
    public BaseDAO() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            this.entity = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            this.entity = null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 插入数据库
     * @param object
     */
    public Integer save(Object object){
        Integer id = null;
        try {
            Session s = getCurrentSession();
            id = (Integer) s.save(object);
            s.flush();
//            log.debug("save successful");
        } catch (RuntimeException re) {
//            log.error("save failed", re);
            throw re;
        }
        return id;
    }

    /**
     * 更新
     * @param object
     */
    public void update(T object){
        getCurrentSession().update(object);
    }
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public T findById(Integer id){
        T object = (T) getCurrentSession().get(this.entity, id);
        return object;
    }

    /**
     * 删除记录
     * @param object
     */
    public void delete(Object object){
        getCurrentSession().delete(object);
    }

    /**
     * 根据id删除数据库记录
     * @param id
     */
    public void delete(Integer id){
        Object o = findById(id);
        getCurrentSession().delete(o);
    }

    /**
     * 根据字段获取相关记录
     * @param propertyName
     * @param value
     * @return
     */
    public List<T> findByProperty(String propertyName, Object value) {
        try {
            String queryString = "from " + entity.getName() +" where "
                    + propertyName + "= ?";
            Query queryObject = getCurrentSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
//            log.error("find by property name failed", re);
            throw re;
        }
    }
    public List<T> findByProperty(Map<String, Object> conditionMap){
        StringBuffer hql = new StringBuffer();
        hql.append("from " + entity.getName());
        if(!conditionMap.isEmpty()){
            Iterator<String> it = conditionMap.keySet().iterator();
            String key =  it.next();
            hql.append(" where " + key + "=" + conditionMap.get(key));
            while (it.hasNext()){
                key = it.next();
                hql.append(" and " + key + "=" + conditionMap.get(key));
            }
        }
        Query query = getCurrentSession().createQuery(hql.toString());
        List<T> list = query.list();
        return list;
    }
    public List<T> findAll(){
        try {
            String queryString = "from " + entity.getName();
            Query queryObject = getCurrentSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
//            log.error("find all failed", re);
            throw re;
        }
    }
    public List<T> findListByHql(String hql){
        Query query = getCurrentSession().createQuery(hql);
        List<T> articleList = query.list();
        return articleList;
    }
}
