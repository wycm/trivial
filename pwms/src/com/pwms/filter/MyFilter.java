package com.pwms.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
/**
 * //不让ueditor请求通过struts2
 * @author wy
 *
 */
public class MyFilter extends OncePerRequestFilter {    
	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //不过滤的url
        String url = req.getRequestURI();
        //System.out.println(url);
        if (url.contains("/res/")) {
            System.out.println("不通过spring mvc");
            chain.doFilter(req, resp);
        }else{
            System.out.println("通过spring mvc");
            super.doFilter(req, resp, chain);
        }
		
	}  
 }
