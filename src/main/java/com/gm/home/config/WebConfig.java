package com.gm.home.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${push.upload.base}")
	private String filePath;
	
	@Value("${push.url.path}")
	private String urlPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("-------------------------------");
		log.info("filePath: {}", filePath);
		log.info("urlPath: {}", urlPath);
		log.info("-------------------------------");
		
		registry.addResourceHandler(urlPath)
				.addResourceLocations(filePath);
	}
}
