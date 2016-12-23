package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.TheoryCourseMapper;
import com.pwms.pojo.TheoryCourse;
import com.pwms.service.ITheoryCourseService;

@Service("importDocService")
public class TheoryCourseServiceImpl implements ITheoryCourseService {

	@Resource
	private TheoryCourseMapper theoryCourseDao;
	
	
	public TheoryCourseMapper getTheoryCourseDao() {
		return theoryCourseDao;
	}

	public void setTheoryCourseDao(TheoryCourseMapper theoryCourseDao) {
		this.theoryCourseDao = theoryCourseDao;
	}

	@Override
	public void save(TheoryCourse tc) {
		// TODO Auto-generated method stub
		theoryCourseDao.insertSelective(tc);
	}

	@Override
	public void updateById(TheoryCourse tc) {
		// TODO Auto-generated method stub
		theoryCourseDao.updateByPrimaryKeySelective(tc);
	}

	@Override
	public void deleteById(TheoryCourse tc) {
		// TODO Auto-generated method stub
		if(tc != null){
			theoryCourseDao.deleteByPrimaryKey(tc.getId());
		}
	}

	@Override
	public TheoryCourse getTheoryCourseById(Integer id) {
		// TODO Auto-generated method stub
		return theoryCourseDao.selectByPrimaryKey(id);
	}

	@Override
	public List<TheoryCourse> getTheoryCourseList() {
		// TODO Auto-generated method stub
		return theoryCourseDao.selectAll();
	}

	@Override
	public List<TheoryCourse> selectTopCourse() {
		// TODO Auto-generated method stub
		return theoryCourseDao.selectTopCourse();
	}


	

}
