package com.bginfosys.dinghyracingclientcontainer.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bginfosys.dinghyracingclientcontainer.security.service.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {
	
	@Bean 
	org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
		return new UserDetailsService();
	}
}
