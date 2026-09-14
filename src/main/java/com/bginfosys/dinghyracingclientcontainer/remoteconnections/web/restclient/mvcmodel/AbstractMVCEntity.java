package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;

public class AbstractMVCEntity {

	protected RestClient restClient;
	
	protected AbstractMVCEntity(RestClient restClient) {
		this.restClient = restClient;
	}
	
}
