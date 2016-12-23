package com.pwms.service;

import java.util.List;

import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;
import com.pwms.pojo.UserCourseRecord;

public interface ICourseService {
	/**
	 * 获取课程
	 * @param id
	 * @return
	 */
	public Course getCourse(Integer id);
	//保存对象
	public void save(Course course);
	//更新对象
	public void updateById(Course course);
	//添加课程到组
	public void addGroup(CoureseGroup group, Course course);
	//上课记录,如果有这个记录，那么久更新记录，始终保存最新的上课记录
	public void addRecord(Course course, UserCourseRecord record);
	
	public List<Course> getCourseByDate();
	/**
	 * 通过组号id来获取课程
	 * @return
	 */
	public List<Course> getCourseByGroupId(int groupid);
}
