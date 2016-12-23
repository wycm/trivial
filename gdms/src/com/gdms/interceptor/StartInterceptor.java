package com.gdms.interceptor;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gdms.controller.ErrorController;
import com.gdms.tools.DateUtils;
import com.gdms.tools.PropertiesLog4j;
import com.gdms.tools.PropertiesUtils;

public class StartInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;//不拦截的url
	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.contains(url)) {
                return true;
            }
        }
        Properties p = PropertiesUtils.loadConfig();
        String startDate = p.getProperty("studentChooseTeacherStartDate");
        String currentDate = DateUtils.getDate();
        if(currentDate.compareTo(startDate) < 0){
        	//系统还未开始
        	response.sendRedirect(request.getContextPath() + "/error?code="+ErrorController.STUDENT_CHOOSE_TEACHER_NOT_START);
        	return false;
        }
        return true;
	}
}
