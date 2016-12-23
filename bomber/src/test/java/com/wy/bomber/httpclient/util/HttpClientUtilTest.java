package com.wy.bomber.httpclient.util;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by root on 11/2/16.
 */

public class HttpClientUtilTest {
    @Test
    public void testGet(){
        try {
            String content = HttpClientUtil.get("https://www.baidu.com");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testProxy(){
        HttpClientUtil.setProxy("120.27.36.59", 8111);
        try {
            String content = HttpClientUtil.get("https://www.itouzi.com/");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCookie(){
        try {
            HttpClientUtil.get("http://www.baidu.com");
            HttpClientUtil.get("http://www.sina.com.cn/");
            HttpClientUtil.get("http://www.baidu.com");
            HttpClientUtil.get("http://www.sina.com.cn/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
