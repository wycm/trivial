package com.gdms.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * ��ȡ��ǰ����
	 * @return
	 */
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		return sdf.format(date);
	}
}
