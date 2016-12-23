package com.blog.service;

import com.blog.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by wy on 2016/6/25 0025.
 */
@Service
public class BaseService<T> {
    private Class<T> entity;
    @Autowired
    private BaseDAO<T> baseDAO;
    public BaseService(){
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            this.entity = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            this.entity = null;
        }
    }
    public Integer save(T t){
        return baseDAO.save(t);
    }
    public void delete(Integer id){
        baseDAO.delete(id);
    }
    public void update(T t){
        baseDAO.update(t);
    }
    public T findById(Integer id){
        return baseDAO.findById(id);
    }
    public List<T> findAll(){
        return baseDAO.findAll();
    }
    public List<T> findByProperty(String property, Object value){
        return baseDAO.findByProperty(property, value);
    }
    public List<T> findByProperty(Map<String, Object> conditionMap){
        return baseDAO.findByProperty(conditionMap);
    }
}
