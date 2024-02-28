package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.dto;

public class DinghyRacingPropertiesDTO {
	
	private String httpRootURL;
	
	private String wsRootURL;

	public DinghyRacingPropertiesDTO() {}
	
	public String getHttpRootURL() {
		return httpRootURL;
	}
	
	public void setHttpRootURL(String httpRootURL) {
		this.httpRootURL = httpRootURL;
	}

	public String getWsRootURL() {
		return wsRootURL;
	}

	public void setWsRootURL(String wsRootURL) {
		this.wsRootURL = wsRootURL;
	}	
}
