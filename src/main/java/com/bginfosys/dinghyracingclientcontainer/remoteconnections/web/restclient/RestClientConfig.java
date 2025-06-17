package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {
	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	RestClient restClient(RestTemplate restTemplate) {
		return new RestClient(restTemplate);
	}
	
}
