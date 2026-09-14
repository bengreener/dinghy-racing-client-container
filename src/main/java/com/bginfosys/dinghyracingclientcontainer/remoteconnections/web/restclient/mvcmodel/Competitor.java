package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.CompetitorHalDTO;

public class Competitor extends AbstractMVCEntity {

	private CompetitorHalDTO competitorHalDTO;
	
	public Competitor(CompetitorHalDTO competitorHalDTO, RestClient restClient) {
		super(restClient);
		this.competitorHalDTO = competitorHalDTO;
	}
	
	public String getName() {
		return competitorHalDTO.getName();
	}
}
