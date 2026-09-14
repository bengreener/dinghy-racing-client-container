package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FleetHalDTO extends AbstractHalDTO {
	
	private String name;
	
	public FleetHalDTO() {}
	
	public FleetHalDTO(String name, Map<String, Link> links) {
		super(links);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
