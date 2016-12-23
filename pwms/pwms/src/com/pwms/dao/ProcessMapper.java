package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.Process;

public interface ProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);
    
    List<Process> selectByNum();

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKeyWithBLOBs(Process record);
}