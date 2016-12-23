package com.pwms.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.ProveLetterMapper;
import com.pwms.pojo.ProveLetter;
import com.pwms.service.IProveLetterService;

@Service("proveLetterService")
public class ProveLetterServiceImpl implements IProveLetterService {

	@Resource
	private ProveLetterMapper proveLetterDao;
	@Override
	public void save(ProveLetter proveletter) {
		// TODO Auto-generated method stub
		this.proveLetterDao.insertSelective(proveletter);
	}

	public ProveLetterMapper getProveLetterDao() {
		return proveLetterDao;
	}

	public void setProveLetterDao(ProveLetterMapper proveLetterDao) {
		this.proveLetterDao = proveLetterDao;
	}

	@Override
	public ProveLetter getProveLetter(int id) {
		// TODO Auto-generated method stub
		return this.proveLetterDao.selectByPrimaryKey(id);
	}

	//ÓÐ´ý²¹³ä
	@Override
	public File exportWord(ProveLetter proveletter) {
		// TODO Auto-generated method stub
		return null;
	}

}
