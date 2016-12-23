package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.NoticeTheroyContruction;

public interface NoticeTheroyContructionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeTheroyContruction record);

    int insertSelective(NoticeTheroyContruction record);

    NoticeTheroyContruction selectByPrimaryKey(Integer id);
    /**
     * 根据类型查找文章，根据时间降序排列
     * @param type
     * @return
     */
    List<NoticeTheroyContruction> selectByType(Integer type);
    
    /**
     * 根据文章类型id
     * 获取该文章下最新的5篇文章
     * @param value
     * @return
     */
    List<NoticeTheroyContruction> selectTopArticleByAtid(Integer [] atId);
    /**
     * 获取最新的党校公告和新闻各10篇
     * @return
     */
    List<NoticeTheroyContruction> selectTopXWAndDXGG();
    
    
    List<NoticeTheroyContruction> selectAll();

    int updateByPrimaryKeySelective(NoticeTheroyContruction record);

    int updateByPrimaryKeyWithBLOBs(NoticeTheroyContruction record);

    int updateByPrimaryKey(NoticeTheroyContruction record);
    
}