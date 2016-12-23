package com.blog.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by wy on 2016/6/25 0025.
 */
public class HtmlUtilsTest {
    @Test
    public void testHtmlUtils(){
        /** HTML转义 **/
        String s = HtmlUtils.htmlEscape("<script>alert(\"王洋123\")</script>");
        System.out.println(s);
        String s2 = HtmlUtils.htmlUnescape(s);
        System.out.println(s2);
        String s3 = StringEscapeUtils.escapeHtml(s2);
        System.out.println(s3);
    }
}
