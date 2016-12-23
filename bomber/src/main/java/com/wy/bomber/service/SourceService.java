package com.wy.bomber.service;

import com.wy.bomber.dao.SourceDao;
import com.wy.bomber.pojo.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 11/2/16.
 */
@Service("sourceService")
public class SourceService {
    @Autowired
    private SourceDao sourceDao;

    public Source findById(Integer id){
        return sourceDao.findById(id);
    }

    public List<Source> findAll(){
        return sourceDao.findAll();
    }

    public List<Source> findAllAvailable(){
        return sourceDao.findAllAvailable();
    }
}
