package com.wy.bomber.dao;

import com.wy.bomber.pojo.Source;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by root on 11/2/16.
 */
public interface SourceDao {
    Source findById(@Param("id") Integer id);

    List<Source> findAll();

    List<Source> findAllAvailable();
}
