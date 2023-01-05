package kr.co.infovine.dkmm.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.infovine.dkmm.interceptor.AuthenticationInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Value("${file.upload}")
    private String UPLOAD_PATH;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludeMapping = new ArrayList<String>();
		excludeMapping.add("/assets/*");
		excludeMapping.add("/assets/**/*");
		excludeMapping.add("/assets/**/**/*");
		excludeMapping.add("/**");
		
		registry.addInterceptor(new AuthenticationInterceptor()).excludePathPatterns(excludeMapping);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry.addResourceHandler("/upload/**").addResourceLocations("file:" + UPLOAD_PATH+"/");
	}
}