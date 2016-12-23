package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.Branch;

public interface BranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
    
    List<Branch> findAll();
    
    List<Branch> findByName(String name);
}