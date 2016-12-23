package com.pwms.dao;

import com.pwms.pojo.FlowPartyMember;

public interface FlowPartyMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FlowPartyMember record);

    int insertSelective(FlowPartyMember record);

    FlowPartyMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FlowPartyMember record);

    int updateByPrimaryKey(FlowPartyMember record);
}