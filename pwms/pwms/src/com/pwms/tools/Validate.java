package com.pwms.tools;

import java.util.Map;
import java.util.Set;

public class Validate{
	/**
	 * 验证提交的参数是否非法（null或者""）
	 * @return
	 */
	public static boolean validateValuesIllegal(Map<?, ?> map){
		Set<?> key = map.keySet(); 
        for(Object values: key.toArray()){ 
	         String k = values.toString(); 
	         String value = ((String[])map.get(values))[0]; 
	         System.out.println(k + "   " + value);
	         if(value == null || value.equals("")){
	        	 return true;
	         }
        } 
		return false;
	}
}