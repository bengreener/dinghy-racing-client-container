package com.bginfosys.dinghyracingclientcontainer.security.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	@Bean
	protected PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder(); // this will be the default encoder for passwords are not stored with specified encoder
		
		// allow use of multiple encoders to accommodate improvements in security over time
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", bcpe);
		
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(bcpe); // set default password encoder for any passwords that do not have an encoder identifier
		
		return passwordEncoder;
	}
}
