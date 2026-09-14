package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.DinghyHalDTO;

public class Dinghy extends AbstractMVCEntity {

	private DinghyHalDTO dinghyHalDTO;
	
	private DinghyClass dinghyClass;
	
	public Dinghy(DinghyHalDTO dinghyHalDTO, RestClient restClient) {
		super(restClient);
		this.dinghyHalDTO = dinghyHalDTO;
	}
	
	public String getSailNumber() {
		return dinghyHalDTO.getSailNumber();
	}
	
	public DinghyClass getDinghyClass() {
		if (dinghyClass == null) {
			dinghyClass = new DinghyClass(restClient.getDinghyClassByURL(dinghyHalDTO.getLinks().get("dinghyClass").getHref()), restClient);
		}
		return dinghyClass;
	}
}
