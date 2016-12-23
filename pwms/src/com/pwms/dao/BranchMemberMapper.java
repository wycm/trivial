package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.Branch;
import com.pwms.pojo.BranchMember;
import com.pwms.pojo.User;

public interface BranchMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BranchMember record);

    int insertSelective(BranchMember record);

    BranchMember selectByPrimaryKey(Integer id);
    
    //通过用户id获取对象
    BranchMember selectByUserId(User user);

    int updateByPrimaryKeySelective(BranchMember record);

    int updateByPrimaryKey(BranchMember record);
    
    //自定义，有待检查
    BranchMember  selectSelective(BranchMember record);
    //获取到支部的所有的对象
    List<BranchMember>  selectByBranchId(Branch record);
    
}