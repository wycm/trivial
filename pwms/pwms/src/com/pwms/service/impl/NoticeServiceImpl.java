package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pwms.dao.ArticletypeMapper;
import com.pwms.dao.NoticeTheroyContructionMapper;
import com.pwms.pojo.Articletype;
import com.pwms.pojo.NoticeTheroyContruction;
import com.pwms.service.ICURD;
import com.pwms.service.INoticeService;
@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {
	@Resource
	private NoticeTheroyContructionMapper noticeTheroyDao;
	@Resource
	private ArticletypeMapper articletypeDao;
	public NoticeTheroyContructionMapper getNoticeTheroyDao() {
		return noticeTheroyDao;
	}

	public void setNoticeTheroyDao(NoticeTheroyContructionMapper noticeTheroyDao) {
		this.noticeTheroyDao = noticeTheroyDao;
	}

	@Override
	public void save(NoticeTheroyContruction notice) {
		// TODO Auto-generated method stub
		this.noticeTheroyDao.insertSelective(notice);
	}

	@Override
	public NoticeTheroyContruction getNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return this.noticeTheroyDao.selectByPrimaryKey(id);
	}

	@Override
	public List<NoticeTheroyContruction> getNoticeByType(Integer type) {
		// TODO Auto-generated method stub
		return this.noticeTheroyDao.selectByType(type);
	}

	@Override
	public boolean modifyNotice(NoticeTheroyContruction notice) {
		// TODO Auto-generated method stub
		if(notice.getId() != null){
		    this.noticeTheroyDao.updateByPrimaryKeySelective(notice);
		    return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean deleteNotice(NoticeTheroyContruction notice) {
		// TODO Auto-generated method stub
		if(notice.getId()!=null){
		    this.noticeTheroyDao.deleteByPrimaryKey(notice.getId());
		    return true;
		}
		else{
			return false;
		}
	}

	@Override
	public List<Articletype> getChildrenAT(Integer pid) {
		// TODO Auto-generated method stub
		return articletypeDao.selectByPid(pid);
	}
	@Override
	public Articletype getArticletypeByid(Integer id){
		return articletypeDao.selectByPrimaryKey(id);
	}

	public List<NoticeTheroyContruction> selectAll() {
		// TODO Auto-generated method stub
//		PageHelper.startPage(1, 5);∑÷“≥≤È—Ø
		return noticeTheroyDao.selectAll();
	}

	@Override
	public List<Articletype> getAllChildrenType() {
		// TODO Auto-generated method stub
		return articletypeDao.selectAllChildrenType();
	}

	@Override
	public Articletype selectByLinkname(String linkname) {
		// TODO Auto-generated method stub
		return articletypeDao.selectByLinkname(linkname);
	}

	@Override
	public List<Articletype> getByPid(Integer pid) {
		// TODO Auto-generated method stub
		return articletypeDao.selectByPid(pid);
	}

	@Override
	public Articletype getArticletypeByid1(Integer id) {
		// TODO Auto-generated method stub
		return articletypeDao.selectByPrimaryKey1(id);
	}

	@Override
	public Articletype getArticletypeByid2(Integer id) {
		// TODO Auto-generated method stub
		return articletypeDao.selectByPrimaryKey2(id);
	}

	@Override
	public List<NoticeTheroyContruction> selectTopArticleByAtid(
			Integer [] atid) {
		// TODO Auto-generated method stub
		return noticeTheroyDao.selectTopArticleByAtid(atid);
	}

	@Override
	public List<NoticeTheroyContruction> selectTopXWAndDXGG() {
		// TODO Auto-generated method stub
		return noticeTheroyDao.selectTopXWAndDXGG();
	}

//	@Override
//	public Articletype getArticletypeByid1(Integer id) {
//		// TODO Auto-generated method stub
//		return articletypeDao.selectByPrimaryKey1(id);
//	}
//
//	@Override
//	public Articletype selectByLinkname1(String linkname) {
//		// TODO Auto-generated method stub
//		return articletypeDao.selectByLinkname1(linkname);
//	}
	
}
