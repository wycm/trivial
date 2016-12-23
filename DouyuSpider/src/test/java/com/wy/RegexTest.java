package com.wy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/21 0021.
 */
public class RegexTest {
    public static void main(String args []){
        String s = "roomId=123456";
        Pattern pattern = Pattern.compile("roomId=([0-9]*)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        System.out.println(matcher.group(1));
    }
}
