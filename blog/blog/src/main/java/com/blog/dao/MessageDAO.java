package com.blog.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.pojo.Message;
@Repository
@Transactional
public class  MessageDAO extends BaseDAO<Message>{
//	private final Logger log = LoggerFactory.getLogger(MessageDAO.class);
	/**
	 * 后台管理时
	 * 获取所有文章
	 * @return 所有留言列表
	 */
	public List<Message> getAllMessage(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("from  com.blog.pojo.Message as m order by m.id desc");
		List<Message> list = query.list();
		
		return list;
	}
	/**
	 * 获取所有父留言
	 * @return 所有留言列表
	 */
	public List<Message> getAllParMessages(){
		Session session = super.getCurrentSession();
		String hql = "from  com.blog.pojo.Message as m where m.parMessage is null order by m.id desc";
		Query q = session.createQuery(hql);
		List<Message> msgs = q.list();
		//System.out.println(msgs.get(0).getUser().getUsername());
		return msgs;
	}
	/**
	 * 删除留言,同时删除留言的user信息
	 * @param id
	 */
	public void deleteMsg(int id){
		Session session = super.getCurrentSession();
		try{
			Message m = (Message)session.get(Message.class, id);
			//System.out.println(m.getUser().getEmail());
			session.delete(m);
			session.delete(m.getUser());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 审核留言
	 * @param id 留言id
	 * @param flag 审核标志
	 */
	public void auditing(int id ,int flag){
		Session session = super.getCurrentSession();
		String hql = "UPDATE  com.blog.pojo.Message as m SET m.throughFlag=" + flag + " ,m.auditingFlag=1 WHERE m.id="+id;
		try{
			Query q = session.createQuery(hql);
			q.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
	/**
	 * 根据parent_id获取已经通过的子留言留言列表
	 * @param parent_id
	 * @return
	 */
	public List<Message> getChildrenMsgs(int parent_id){
		Session session = super.getCurrentSession();
		String hql = "from  com.blog.pojo.Message as m where throughFlag=1 and m.parMessage.id=" + parent_id;
		Query q = session.createQuery(hql);
		List<Message> cMsgs = q.list();
		
		return cMsgs;
	}
	/**
	 * 获取所有未审核的留言
	 * @return
	 */
	public List<Message> getUnAuditing(){
		Session session = super.getCurrentSession();
		String hql = "from  com.blog.pojo.Message as m where auditingFlag=0";
		Query q = session.createQuery(hql);
		List<Message> cMsgs = q.list();
		
		return cMsgs;
	}
	/**
	 * 获取最新通过审核的评论
	 * @return 5条最新评论
	 */
	public List<Message> getLatestMessage(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("from  com.blog.pojo.Message as m where m.throughFlag=1 order by m.id desc");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Message> list = query.list();
		//System.out.println(list.get(0).getUser().getUsername());
		
		return list;
	}
	/**
	 * 顶留言
	 * @param id
	 */
	public void setMessageLight(int id){
		String hql = "update  com.blog.pojo.Message as m set m.light=m.light+1 where m.id=" + id;
		Session session = super.getCurrentSession();
		try{
			Query q = session.createQuery(hql);
			q.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
	/**
	 * 获取数据库中留言数量
	 * @return 留言数量
	 */
	public int getMessageCount(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select count(*) from  com.blog.pojo.Message as m");
		int count = ((Number)query.uniqueResult()).intValue();
		
		System.out.println(count);
		return count;
	}
	public Message getMessage(Integer id){
		Session session = super.getCurrentSession();
		Message message;
		message = (Message) session.get(Message.class, id);
		return message;
	}
	public List<Message> findAdminVOList(){
		String hql = "select new com.blog.pojo.Message(id,content,time,throughFlag,auditingFlag,user.username) " +
				"from " + super.entity.getName();
		return findListByHql(hql);
	}
}
