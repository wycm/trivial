package com.pwms.service;

/**
 * 基本的增删改查
 * @author Administrator
 *
 */
public interface ICURD{

	public void save(Object entity);

	public void update(Object object);
	
	public void deleteById(Integer id);
	
	public Object getEntityById(Integer id);
}