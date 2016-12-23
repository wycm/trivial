package com.blog.dao;

import com.blog.pojo.Comment;
import com.blog.util.MySpringJUnit4ClassRunner;
import com.blog.pojo.ArticleContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wy on 2016/6/5 0005.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class BaseDAOTest extends HibernateSessionManage{
    @Autowired
    private BaseDAO baseDAO;
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private ArticleContentDAO articleContentDAO;
    @Test
    public void testSave(){
        ArticleContent ac = new ArticleContent();
        ac.setContent("test1111");
        articleContentDAO.save(ac);
    }
    @Test
    public void testGet(){
        Comment c = (Comment) commentDAO.findById(24);
        System.out.println(c.toString());

    }
    /**
     * 测试delete方法删除评论
     */
    @Test
    public void testDelete(){
        commentDAO.delete(27);
    }
    @Test
    public void testGetByProperty(){
        List<Comment> list = null;
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("article.id",56);
        conditionMap.put("parComment.id",17);
        list = commentDAO.findByProperty(conditionMap);
        System.out.println(list.size());
    }
}
