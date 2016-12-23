package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.CoureseGroupMapper;
import com.pwms.dao.CourseMapper;
import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;
import com.pwms.service.ICourseGroupService;
@Service("groupService")
public class CourseGroupServiceImpl implements ICourseGroupService {
	@Resource
	private CoureseGroupMapper courseGroupDao;
	@Resource
	private CourseMapper courseDao;
	public CoureseGroupMapper getCourseGroupDao() {
		return courseGroupDao;
	}

	public void setCourseGroupDao(CoureseGroupMapper courseGroupDao) {
		this.courseGroupDao = courseGroupDao;
	}

	public CourseMapper getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseMapper courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public List<CoureseGroup> getCourseGroupList() {
		// TODO Auto-generated method stub
		return this.courseGroupDao.selectAll();
	}

	@Override
	public CoureseGroup getCourseGroupById(int id) {
		// TODO Auto-generated method stub
		return this.courseGroupDao.selectByPrimaryKey(id);
	}

//	@Override
//	public List<Course> getCourseListById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public void deleteGroupById(int id) {
		// TODO Auto-generated method stub
		this.courseGroupDao.deleteByPrimaryKey(id);
		this.courseDao.deleteByGroupId(id);
	}

	@Override
	public void addCourseGroup(String name, int type) {
		// TODO Auto-generated method stub
		CoureseGroup group = new CoureseGroup();
		group.setName(name);
		group.setType(type);
		this.courseGroupDao.insertSelective(group);
	}

	@Override
	public void addPartyCourse(String name) {
		// TODO Auto-generated method stub
		this.addCourseGroup(name, PARTY_TYPE);
	}

	@Override
	public void addPositiveCourse(String name) {
		// TODO Auto-generated method stub
		this.addCourseGroup(name, POSITIVE_TYPE);
	}

	@Override
	public void addAllCourse(String name) {
		// TODO Auto-generated method stub
		this.addCourseGroup(name, ALL_TYPE);
	}

}
