package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.Articletype;
import com.pwms.pojo.NoticeTheroyContruction;

public interface ArticletypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Articletype record);

    int insertSelective(Articletype record);
    /**
     * 通过id查询，并且懒加载关联对象
     * @param id 
     * @return
     */
    Articletype selectByPrimaryKey(Integer id);

    Articletype selectByPrimaryKey1(Integer id);
    
    Articletype selectByPrimaryKey2(Integer id);

    int updateByPrimaryKeySelective(Articletype record);

    int updateByPrimaryKey(Articletype record);
    /**
     * 通过pid查找Articletype
     * @param pid
     * @return Articletype列表
     */
    List<Articletype> selectByPid(Integer pid);
    /**
     * 获取所有 chlidrenarticletype
     * @return chlidrenarticletype列表
     */
    List<Articletype> selectAllChildrenType();
    /**
     * 通过linkname查找articletype，并且获取关联
     * @param linkname 链接名
     * @return
     */
    Articletype selectByLinkname(String linkname);
    
//    Articletype selectByLinkname1(String linkname);
    
}