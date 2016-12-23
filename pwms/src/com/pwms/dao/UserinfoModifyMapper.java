package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.UserinfoModify;

public interface UserinfoModifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserinfoModify record);

    int insertSelective(UserinfoModify record);

    UserinfoModify selectByPrimaryKey(Integer id);
    UserinfoModify selectByUserid(Integer id);
    /**
     * 根据标志查询自己支部的修改个人信息的记录
     * @param auditing_flag 0:未审核 1：通过审核 2： 未通过审核
     * @param userid
     * @return
     */
    List<UserinfoModify> selectByLeaderFLag(Integer auditing_flag, Integer userid);
    /**
     * 获取所有的某个标志的用户信息修改记录
     * @param auditing_flag
     * @return
     */
    List<UserinfoModify> selectByFlag(Integer auditing_flag);

    int updateByPrimaryKeySelective(UserinfoModify record);

    int updateByPrimaryKey(UserinfoModify record);
    
}