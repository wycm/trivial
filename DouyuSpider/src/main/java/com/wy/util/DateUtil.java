package com.wy.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yangwang on 16-8-19.
 */
public class DateUtil {
    public static long getTimestamp(){
        Date date = new Date();
        long timestamp = date.getTime() / 1000;
        return timestamp;
    }
}
