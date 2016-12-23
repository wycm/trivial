package com.pwms.service;

import java.util.List;

import com.pwms.pojo.TheoryCourse;

public interface ITheoryCourseService {
	//保存对象
	public void save(TheoryCourse tc);
	//更新对象
	public void updateById(TheoryCourse tc);
	//删除对象 
	public void deleteById(TheoryCourse tc);
	//获取对象
	public TheoryCourse getTheoryCourseById(Integer id);
	/**
	 * 所有课程
	 * @param id
	 * @return
	 */
	public List<TheoryCourse> getTheoryCourseList();
	/**
	 * 获取最新top5理论课程
	 * @return
	 */
	public List<TheoryCourse> selectTopCourse();

}
