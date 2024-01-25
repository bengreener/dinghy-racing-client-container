package com.bginfosys.dinghyracingclientcontainer.security.configuration;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.bginfosys.dinghyracingclientcontainer.security.service.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Bean org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
		return new UserDetailsService();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
		    .requestMatchers(toH2Console()).permitAll()
		    .requestMatchers("/**").authenticated()
	    )
	    .formLogin(withDefaults());
		http.csrf((csrf) -> {
			csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
			csrf.ignoringRequestMatchers(toH2Console());
		});
		http.headers(headers -> 
	    	headers.frameOptions(frameOptions -> 
	    		frameOptions.sameOrigin()
			)
    	);
		return http.build();
	}
	
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
