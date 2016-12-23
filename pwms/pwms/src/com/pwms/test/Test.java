package com.pwms.test;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.pwms.tools.Md5Util;

/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class Test {
	public static void main(String args []){
		RestTemplate r = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	}
}
