package com.ssmm.dao;

import com.ssmm.pojo.User;
public interface UserDAO {
    User selectByPrimaryKey(Integer id);
}
