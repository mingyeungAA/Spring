package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : "+remoteAddr+"\n");
		sb.append("* uri : "+uri+"\n");
		sb.append("* url : "+url+"\n");
		sb.append("* queryString : "+queryString+"\n");
		sb.append("* referer : "+referer+"\n");
		sb.append("* agent : "+agent);
		
		System.out.println("LogFilter");
		System.out.println(sb);
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		

	}

}
