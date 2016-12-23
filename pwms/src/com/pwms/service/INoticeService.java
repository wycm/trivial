package com.pwms.service;

import java.util.List;

import com.pwms.pojo.Articletype;
import com.pwms.pojo.NoticeTheroyContruction;

public interface INoticeService {
	/**
	 * 保存对象
	 * @param notice
	 */
	public void save(NoticeTheroyContruction notice);
	/**
	 * 通过id来获取对象
	 * @param id
	 * @return
	 */
	public NoticeTheroyContruction getNoticeById(Integer id);
	/**
	 * 通过类型来查找对象
	 * @param 
	 * @return
	 */
	public List<NoticeTheroyContruction> getNoticeByType(Integer type);
	
	public boolean modifyNotice(NoticeTheroyContruction notice);
	
	public boolean deleteNotice(NoticeTheroyContruction notice);
	/**
     * 通过pid查找Articletype
     * @param pid
     * @return Articletype列表
     */
	public List<Articletype> getChildrenAT(Integer pid);
	
	public Articletype getArticletypeByid(Integer id);
	
	List<NoticeTheroyContruction> selectAll();
	 /**
     * 获取所有 chlidrenarticletype
     * @return chlidrenarticletype列表
     */
	List<Articletype> getAllChildrenType();
	
	public Articletype selectByLinkname(String linkname);
	
	public Articletype getArticletypeByid1(Integer id);
	
	public Articletype getArticletypeByid2(Integer id);
	
//	public Articletype selectByLinkname1(String linkname);
	/**
     * 通过pid查找Articletype
     * @param pid
     * @return Articletype列表
     */
	List<Articletype> getByPid(Integer pid);
	
	List<NoticeTheroyContruction> selectTopArticleByAtid(Integer [] atid);
	
	List<NoticeTheroyContruction> selectTopXWAndDXGG();
}
