package com.pwms.service;

import java.util.List;

import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;

public interface ICourseGroupService {
	final static int POSITIVE_TYPE=1;
	final static int PARTY_TYPE=2;
	final static int ALL_TYPE=4;
	/**
	 * 查询所有的课程组
	 * @return
	 */
	public List<CoureseGroup> getCourseGroupList();
	/**
	 * 查看某一个课程组
	 * @param id
	 * @return
	 */
	public CoureseGroup getCourseGroupById(int id);
//	/**
//	 * 查看课程组所有的课程
//	 * @param id
//	 * @return
//	 */
//	public List<Course> getCourseListById(int id);
	/**
	 * 增加一个课程组
	 * @param group
	 */
	public void addCourseGroup(String name, int type);
	/**
	 * 删除课程组
	 * @param id
	 */
	public void deleteGroupById(int id);
//	/**增加课程到课程组
//	 * 
//	 * @param course
//	 * @param group
//	 */
//	public void addCourse2Group(Course course, CoureseGroup group);
	
	/**
	 * 添加党员课程
	 * @param name
	 */
	public void addPartyCourse(String name);
	/**
	 * 添加积极分子课程
	 * @param name
	 */
	public void addPositiveCourse(String name);
	/**
	 * 添加所有的课程
	 * @param name
	 */
	public void addAllCourse(String name);
	
}
