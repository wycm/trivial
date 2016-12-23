package com.blog.util;
import com.blog.util.StaticConstants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import static com.blog.util.StaticConstants.ASC;

/**
 * Created by wy on 2016/6/19 0019.
 */
public class BeanUtilsTest {
    @Test
    public void testCopyProperties(){
        POTest p = new POTest();
        p.setUsername("wangyang");
        p.setPsd("123");
        VOTest v = new VOTest();
        BeanUtils.copyProperties(p, v);
        Assert.assertEquals("wangyang", v.getUsername());
    }
    @Test
    public void enumTest(){
        System.out.println(ASC);
        System.out.println(StaticConstants.orderEnum.asc);
    }
}
