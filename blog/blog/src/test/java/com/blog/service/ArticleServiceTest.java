package com.blog.service;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleContent;
import com.blog.util.MySpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by wy on 2016/6/22 0022.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTypeService articleTypeService;
    @Test
    public void insertArticle(){
        Article a = new Article();
        ArticleContent ac = new ArticleContent();
        ac.setContent("test");
        a.setArticleContent(ac);
        articleService.insertArticle(a, 40);
    }
    @Test
    public void insertArticleType(){
        articleTypeService.insertArticleType(1, "test");
    }
    @Test
    public void findById(){
        articleService.findById(40);
    }
}
