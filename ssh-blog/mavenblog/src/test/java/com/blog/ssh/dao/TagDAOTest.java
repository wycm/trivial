package com.blog.ssh.dao;

import com.blog.ssh.pojo.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wy on 2016/6/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TagDAOTest {
    @Autowired
    private TagDAO tagDAO;
    @Test
    public void getTagsByArticleId(){
        List<Tag> tags = tagDAO.getTagsByArticleId(54);
    }
}
