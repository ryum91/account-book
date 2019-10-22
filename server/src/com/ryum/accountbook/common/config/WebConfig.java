package com.ryum.accountbook.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ryum.accountbook.common.interceptor.AlwaysInterceptor;

/**
 * 설정 클래스
 * 
 * @author ryum
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private AlwaysInterceptor alwaysInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(alwaysInterceptor).addPathPatterns("/**");
	}
	
}
