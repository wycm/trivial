package com.wy.util;

import com.wy.entity.ServerInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class ParseUtils {
    public static List<ServerInfo> parseDanMuServer(){
        return null;
    }
    public static String filterMessageContent(String str){
        return str.trim().replace("@A", "@").replace("@S", "/");
    }
}
