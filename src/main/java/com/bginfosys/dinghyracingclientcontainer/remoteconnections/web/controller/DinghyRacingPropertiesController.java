package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.dto.DinghyRacingPropertiesDTO;

@RestController
@RequestMapping(value = "/dinghyracingproperties")
public class DinghyRacingPropertiesController {
	
	@Value("${dinghy-racing-httpRootURL}")
	String httpRootURL;
	
	@Value("${dinghy-racing-wsRootURL}")
	String wsRootURL;
	
	@GetMapping(value = "/connectionurls")
	public DinghyRacingPropertiesDTO getConnectionURLs() {
		DinghyRacingPropertiesDTO drps = new DinghyRacingPropertiesDTO();
		drps.setHttpRootURL(httpRootURL);
		drps.setWsRootURL(wsRootURL);
		
		return drps;
	}
}
