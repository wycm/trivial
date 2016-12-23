package com.pwms.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.CourseMapper;
import com.pwms.dao.UserCourseRecordMapper;
import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;
import com.pwms.pojo.UserCourseRecord;
import com.pwms.service.ICURD;
import com.pwms.service.ICourseService;
@Service("courseService")
public class CourseServiceImpl implements ICourseService {
	@Resource
	private CourseMapper courseDao;
	private UserCourseRecordMapper userCourseRecordDao;
//	private UserCourseRecordMapper courseGroupDao;
	@Override
	public Course getCourse(Integer id) {
		// TODO Auto-generated method stub
		return this.courseDao.selectByPrimaryKey(id);
	}

	public CourseMapper getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseMapper courseDao) {
		this.courseDao = courseDao;
	}

	public UserCourseRecordMapper getUserCourseRecordDao() {
		return userCourseRecordDao;
	}

	public void setUserCourseRecordDao(UserCourseRecordMapper userCourseRecordDao) {
		this.userCourseRecordDao = userCourseRecordDao;
	}

	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		this.courseDao.insertSelective(course);
	}

	@Override
	public void updateById(Course course) {
		// TODO Auto-generated method stub
		this.courseDao.updateByPrimaryKeySelective(course);
	}

	@Override
	public void addGroup(CoureseGroup group, Course course) {
		// TODO Auto-generated method stub
		course.setGroupId(group.getId());
		this.updateById(course);
	}

	@Override
	public void addRecord(Course course, UserCourseRecord record) {
		// TODO Auto-generated method stub
		record.setCourseId(course.getId());
		userCourseRecordDao.insertSelective(record);
	}

	@Override
	public List<Course> getCourseByDate() {
		// TODO Auto-generated method stub
		List<Course> courseList = this.courseDao.selectByDate();
		if(courseList==null){
			return Collections.emptyList();
		}
		return courseList;
	}

	@Override
	public List<Course> getCourseByGroupId(int groupid) {
		// TODO Auto-generated method stub
		return this.courseDao.selectByGroupId(groupid);
	}

}
