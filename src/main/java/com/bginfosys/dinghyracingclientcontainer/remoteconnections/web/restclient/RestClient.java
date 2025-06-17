package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Race;

public class RestClient {
	
	@Value("${dinghy-racing-httpRootURL}")
	String httpRootURL;
	
	private RestTemplate restTemplate;
	
	public RestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	
	public Race getRaceById(Long raceId) {
		Race race = restTemplate.getForObject(httpRootURL + "/races/" + raceId.toString(), Race.class);
		return race;
	}
}
