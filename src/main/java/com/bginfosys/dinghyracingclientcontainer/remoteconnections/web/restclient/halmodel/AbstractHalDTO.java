package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractHalDTO {

	@JsonProperty("_links")
	protected Map<String, Link> links;

	protected AbstractHalDTO() {}
	
	protected AbstractHalDTO(Map<String, Link> links) {
		this.links = links;
	}
	
	public Map<String, Link> getLinks() {
		return links;
	}
	
    public void setLinks(Map<String, Link> links) {
    		this.links = links;
    	}
}
