package com.bginfosys.dinghyracingclientcontainer.security.configuration;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
		
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
}
