package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("🎗[LoginInterceptor] : preHandle🎗");
		
		
		// spring 3.2 이상부터는 servlet-context.xml에서 <execulude-mapping-path>를 통해 설정할 수 있다.
		if(request.getRequestURI().contains("/loginform.do") || request.getRequestURI().contains("/ajaxlogin.do") || 
				request.getSession().getAttribute("login") != null || request.getRequestURI().contains("/test.do") ||
				request.getRequestURI().contains("/registform.do") || request.getRequestURI().contains("/registres.do"))  //요 조건일때만 controller로 넘어간다.!
		{
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {  //로그인이 안됐다면,
			response.sendRedirect("loginform.do");
			return false;
			
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {  //postHandle : DS에서 컨트롤러로 갔다가, 컨트롤러가 다시 DS로 값을 넘겨줄때 실행됨
		logger.info("🎗[LoginInterceptor] : postHandle🎗");
		//logger.info(modelAndView.getViewName());  //어떤 view(jsp)를 가져오는지 알려줌
		
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());   //
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {  //afterCompletion : 
		logger.info("🎗[LoginInterceptor] : afterCompletion🎗");

	}

}
