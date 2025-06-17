package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Race(String name, Long plannedLaps, String signedUpURL) {

	public String getName() {
		return name;
	}
}
