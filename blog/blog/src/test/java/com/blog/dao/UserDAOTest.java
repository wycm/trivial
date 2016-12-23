package com.blog.dao;

import com.blog.util.MySpringJUnit4ClassRunner;
import com.blog.service.BloginfoService;
import com.blog.pojo.BlogInfo;
import com.blog.pojo.User;
import com.blog.vo.UserVO;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
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

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016/6/5 0005.
 */
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BlogInfoDAO bloginfoDAO;
    @Autowired
    private BloginfoService bloginfoService;
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
    /**
     * 测试一对一插入
     */
    @Test
    public void testMerge(){
        BlogInfo bi = new BlogInfo();
        bi.setVisits(10);
        bloginfoDAO.save(bi);
        User u = new User();
        u.setUsername("test");
        u.setBloginfo(bi);
        userDAO.save(u);
    }
    @Test
    public void testFindById(){
        User u = (User) userDAO.findById(35);
//        System.out.println(u.getBloginfo().getIntro());
        UserVO uv = new UserVO();
        System.out.println(u.toString());
//        System.out.println(uv.toString());
//        BeanUtils.copyProperties(u, uv);
//        System.out.println(u.toString());
//        System.out.println(uv.getArticles().size());
    }
    @Test
    public void testGetMsgCounts(){
        int i = userDAO.getArticleCounts(35);
        int j  = userDAO.getBlogComments(35);
        System.out.println(i);
        System.out.println(j);
    }
    @Test
    public void testJackson(){
        List<User> userList = userDAO.findAll();
        List<UserVO> userVOList = new ArrayList<UserVO>();
        for(User u:userList){
            UserVO uv = new UserVO();
            BeanUtils.copyProperties(u, uv,"password","url","headpicname","articles","bloginfo");
            userVOList.add(uv);
        }
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
//            mapper.writeValue(gen,userVOList);
            result = mapper.writeValueAsString(userVOList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结果:" + result);
    }
}
