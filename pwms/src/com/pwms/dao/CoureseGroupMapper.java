package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.CoureseGroup;

public interface CoureseGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoureseGroup record);

    int insertSelective(CoureseGroup record);

    CoureseGroup selectByPrimaryKey(Integer id);
    
    List<CoureseGroup> selectAll();

    int updateByPrimaryKeySelective(CoureseGroup record);

    int updateByPrimaryKey(CoureseGroup record);
}