package com.blog.service;

import com.blog.util.MySpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by wy on 2016/6/28 0028.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Test
    public void testFindByProperty(){
        commentService.findByProperty("user.id", 35);
    }
}
