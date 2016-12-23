package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.ProcessRecord;
import com.pwms.pojo.User;

public interface ProcessRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessRecord record);

    int insertSelective(ProcessRecord record);

    ProcessRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessRecord record);
    
    int updateByPrimaryKeyWithBLOBs(ProcessRecord record);
    
    int updateByPrimaryKey(ProcessRecord record);
    
    int selectLastByUser(User user);
    
    List<ProcessRecord> selectByUser(User user);
    
    ProcessRecord selectByProcessUser(int processId, int userId);

}
