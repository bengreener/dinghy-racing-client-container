package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.dto;

public class DinghyRacingPropertiesDTO {
	
	private String httpURL;
	
	private String wsRootURL;

	public String getHttpURL() {
		return httpURL;
	}

	public DinghyRacingPropertiesDTO() {}
	
	public void setHttpURL(String httpURL) {
		this.httpURL = httpURL;
	}

	public String getWsRootURL() {
		return wsRootURL;
	}

	public void setWsRootURL(String wsRootURL) {
		this.wsRootURL = wsRootURL;
	}	
}
