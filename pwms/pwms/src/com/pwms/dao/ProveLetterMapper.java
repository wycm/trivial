package com.pwms.dao;

import com.pwms.pojo.ProveLetter;

public interface ProveLetterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProveLetter record);

    int insertSelective(ProveLetter record);

    ProveLetter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProveLetter record);

    int updateByPrimaryKey(ProveLetter record);
}