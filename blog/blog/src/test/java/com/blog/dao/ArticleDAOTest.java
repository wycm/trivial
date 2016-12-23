package com.blog.dao;

import com.blog.pojo.Article;
import com.blog.pojo.Comment;
import com.blog.pojo.Tag;
import com.blog.util.MySpringJUnit4ClassRunner;
import com.blog.service.ArticleService;
import com.blog.pojo.ArticleContent;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by wy on 2016/6/3 0003.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ArticleDAOTest {
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private ArticleService articleService;
    private List<Article> articleList;
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    @Before
    public void openSession()  throws Exception {
        session = sessionFactory.openSession();
        session.setFlushMode(FlushMode.MANUAL);
        TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(session));
    }

    @After
    public void closeSession()  throws Exception {
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.closeSession(session);
    }
    @Test
    public void testGetLatestArticleTitle(){
        List<Article> articleList = articleDAO.getLatestArticleList();
        String s = articleList.get(0).getContent();
        assertEquals(null, s);
    }
    @Test
    public void testGetAllArticle(){
        articleList = articleDAO.findAll();
        for(Article a:articleList){
            System.out.println(a.toString());
        }
    }
    @Test
    public void testInsertArticle(){
        Article a = new Article();
        ArticleContent ac = new ArticleContent();
        ac.setContent("test");
        a.setArticleContent(ac);
        articleService.insertArticle(a, 1);
    }
    @Test
    public void testGetHotArticleTitle(){
        List<Article> articleList = articleDAO.getHotArticleList(35);
        for(Article a:articleList){
            System.out.println(a.toString());
        }
    }
    @Test
    public void testFindById(){
//        Article a = articleDAO.findById(40);
//        Set<Comment> set = a.getComments();
//        for(Comment c:set){
//            System.out.println(c.getContent());
//        }
        articleDAO.findAdminVOList();
    }
    @Test
    public void testGetRandomArticleList(){
        List<Article> articleList = articleDAO.getRandomArticleList(35);
        for(Article a:articleList){
            System.out.println(a.toString());
        }
    }
}
