package com.rohim.springboot2.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rohim.springboot2.configs.interceptors.LogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LogInterceptor logInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor);
//			.addPathPatterns("/information/**", "/updatePassword/**")
//			.excludePathPatterns("/login/**", "/register/**", "/css/**", "/images/**", "/js/**");
	}
}
