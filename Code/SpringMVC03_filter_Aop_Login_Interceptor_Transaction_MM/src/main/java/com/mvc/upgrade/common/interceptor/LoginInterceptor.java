package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("**[LoginInterceptor]** : preHandle");
		
		if(request.getRequestURI().contains("/loginform.do") || request.getRequestURI().contains("/ajaxlogin.do") || 
				request.getSession().getAttribute("login") != null || request.getRequestURI().contains("/test.do")) {  //이 조건일때만 controller로 넘어간다.
			
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {  //session에 값이 없으면,
			response.sendRedirect("loginform.do");
			return false;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("**[LoginInterceptor]** : postHandle");
		//logger.info(modelAndView.getViewName());  //=>어떤 view를 가져오는지 알려줌
		//=>이걸 쓰면 "통신실패" 뜸!
		//=>비동기 통신이라서, model객체에 안담겨있음 (modelAndView == null>
		
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("**[LoginInterceptor]** : afterCompletion");
	}

}
