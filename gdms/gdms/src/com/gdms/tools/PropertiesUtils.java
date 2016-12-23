package com.gdms.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * 
 * @author wy
 *
 */
public class PropertiesUtils {
	/**
	 * ����·������properties�ļ�
	 * @param name
	 * @return
	 */
	public static Properties getProperties(String name){
		Properties p = new Properties();
		try {
			p.load(PropertiesUtils.class.getResourceAsStream(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * ����config�����ļ�
	 * @return
	 */
	public static Properties loadConfig(){
		return getProperties("/com/gdms/resources/config.properties");
	}
	/**
	 * �����ļ������ָ��·��
	 * @param p
	 * @param path
	 */
	public static void writeProperties(Properties p, String path){
		FileOutputStream fos = null;
		try {
			path = (PropertiesUtils.class.getClassLoader().getResource("").toURI()).getPath()+path;
			System.out.println(path);
			fos = new FileOutputStream(path);
			p.store(fos, "test");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ����config�����ļ�
	 * @param p
	 */
	public static void writeConfigProperties(Properties p){
		writeProperties(p,"/com/gdms/resources/config.properties");
	}
	public static void main(String args []){
		Properties p = loadConfig();
		p.setProperty("test", "test");
		writeConfigProperties(p);
		System.out.println(DateUtils.getDate());
	}
}
