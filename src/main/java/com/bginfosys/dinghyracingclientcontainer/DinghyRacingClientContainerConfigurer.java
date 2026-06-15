package com.bginfosys.dinghyracingclientcontainer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DinghyRacingClientContainerConfigurer implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/external/{:local.css}")
			.addResourceLocations("file:./local/"); // can't pick up file from web application root; fails ResourceHandlerUtils.isResourceUnderLocation() check
		registry
			.addResourceHandler("/external/{:\\w+\\.png}")
			.addResourceLocations("file:./local/"); // can't pick up file from web application root; fails ResourceHandlerUtils.isResourceUnderLocation() check
		registry
			.addResourceHandler("/external/{:\\w+\\.svg}")
			.addResourceLocations("file:./local/"); // can't pick up file from web application root; fails ResourceHandlerUtils.isResourceUnderLocation() check
	}
}
