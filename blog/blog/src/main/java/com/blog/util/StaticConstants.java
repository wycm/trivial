package com.blog.util;

import com.blog.pojo.BasePOJO;

/**
 * Created by wy on 2016/6/22 0022.
 */
public class StaticConstants {
    public static final String POJO_PACKAGE_NAME;
    public static final String DESC = "desc";
    public static final String ASC = "asc";
    public enum orderEnum {
        asc, desc;
    }
    public enum personCenterEnum {
        fbwz,//发布文章
        wzgl,//文章管理
        plgl,//评论管理
        grzlsz;//个人资料设置
    }
    static {
        Class<BasePOJO> c = BasePOJO.class;
        String pn = c.getName();
        POJO_PACKAGE_NAME = pn.substring(0, pn.indexOf(c.getSimpleName()) - 1);
//        System.out.println(POJO_PACKAGE_NAME);
    }
    public static void main(String args []){

    }
}
