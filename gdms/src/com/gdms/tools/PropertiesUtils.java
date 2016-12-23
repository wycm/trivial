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
	 * 根据路径加载properties文件
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
	 * 加载config配置文件
	 * @return
	 */
	public static Properties loadConfig(){
		return getProperties("/com/gdms/resources/config.properties");
	}
	/**
	 * 配置文件输出到指定路径
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
	 * 保存config配置文件
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
