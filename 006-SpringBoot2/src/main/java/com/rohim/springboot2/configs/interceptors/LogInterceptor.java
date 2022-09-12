package com.rohim.springboot2.configs.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rohim.springboot2.utils.HttpUtils;

@Component
public class LogInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String queryStr = "";
		if (request.getQueryString() != null) {
			queryStr += "?" + request.getQueryString();
		}
		
		String userName = "";
		if (request.getUserPrincipal() != null) {
			userName = request.getUserPrincipal().getName();
		}
		
		String sessionId = "";
		if (request.getSession() != null) {
			sessionId = request.getSession().getId();
		}
		
		String logMsg = sessionId + " User:" + userName 
				+ " from " + HttpUtils.getRequestIP(request)
				+ " call "	+ request.getMethod() + " " + request.getRequestURL() + queryStr;
		logger.debug(logMsg);
		
		// print all headers
//		Enumeration<String> headerNames = request.getHeaderNames();
//	    if (headerNames != null) {
//	        while (headerNames.hasMoreElements()) {
//	        	String headerName = headerNames.nextElement();
//	            System.out.println(headerName + ":" + request.getHeader(headerName));
//            }
//	    }
		
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
