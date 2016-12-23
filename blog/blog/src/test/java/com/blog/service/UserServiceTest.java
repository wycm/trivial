package com.blog.service;

import com.blog.pojo.User;
import com.blog.util.MySpringJUnit4ClassRunner;
import com.blog.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by wy on 2016/6/19 0019.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;
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
    public void testSetUserSession(){
//        UserVO uv = userService.setUserSession(48);
//        System.out.println(uv.getId());
    }
    @Test
    public void testCheckLogin(){
//        int result = userService.checkLogin("admin","12345");
//        System.out.println(result);
    }
    @Test
    public void testCopyProperty(){
        User user = userService.findById(35);
        System.out.println(user.getArticles().size());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        System.out.println(userVO.getArticles().size());
        System.out.println(userVO.getBloginfo().getVisits());
    }
}
