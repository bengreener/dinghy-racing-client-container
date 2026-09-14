package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.DinghyClassHalDTO;

public class DinghyClass extends AbstractMVCEntity {

	private DinghyClassHalDTO dinghyClassHalDTO;
	
	public DinghyClass(DinghyClassHalDTO dinghyClassHalDTO, RestClient restClient) {
		super(restClient);
		this.dinghyClassHalDTO = dinghyClassHalDTO;
	}
	
	public String getName() {
		return dinghyClassHalDTO.getName();
	}
	
	public Integer getPortsmouthNumber() {
		return dinghyClassHalDTO.getPortsmouthNumber();
	}
}
