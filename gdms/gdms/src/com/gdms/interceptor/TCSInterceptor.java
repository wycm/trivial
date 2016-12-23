package com.gdms.interceptor;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gdms.controller.ErrorController;
import com.gdms.tools.DateUtils;
import com.gdms.tools.PropertiesUtils;

/**
 * 学生选择老师拦截器
 * @author wy
 *
 */
public class TCSInterceptor implements HandlerInterceptor{
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
		String currentDate = DateUtils.getDate();
		Properties p = PropertiesUtils.loadConfig();
		String startDate = p.getProperty("teacherChooseStudentStartDate");
		String endDate = p.getProperty("teacherChooseStudentEndDate");
		if(currentDate.compareTo(startDate) < 0){
			//当前时间小于开始时间
			String url=request.getContextPath()+"/error?code="+ErrorController.TEACHER_CHOOSE_STUDENT_NOT_START;
			response.sendRedirect(url);
			return false;
		}
		if(currentDate.compareTo(endDate) > 0){
			//当前时间大于结束时间
			String url=request.getContextPath()+"/error?code="+ErrorController.TEACHER_CHOOSE_STUDENT_END;
			response.sendRedirect(url);
			return false;
		}
		return true;
	}

}
