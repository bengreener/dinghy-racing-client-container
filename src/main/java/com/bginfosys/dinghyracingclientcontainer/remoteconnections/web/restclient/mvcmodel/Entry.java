package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.time.Duration;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.EntryHalDTO;

public class Entry extends AbstractMVCEntity {

	private EntryHalDTO entryHalDTO;
	
	private Competitor helm;
	
	private Dinghy dinghy;
	
	public Entry(EntryHalDTO entryHalDTO, RestClient restClient) {
		super(restClient);
		this.entryHalDTO = entryHalDTO;
	}
	
	public Competitor getHelm() {
		if (helm == null) {
			helm = new Competitor(restClient.getCompetitorByURL(entryHalDTO.getLinks().get("helm").getHref()), restClient);
		}
		return helm;
	}
	
	public Duration getTime() {
		return entryHalDTO.getSumOfLapTimes();
	}
	
	public String getScoringAbbreviation() {
		return entryHalDTO.getScoringAbbreviation();
	}
	
	public Integer getLapsSailed() {
		return entryHalDTO.getLapsSailed();
	}
	
	public Dinghy getDinghy() {
		if (dinghy == null) {
			dinghy = new Dinghy(restClient.getDinghyByURL(entryHalDTO.getLinks().get("dinghy").getHref()), restClient);
		}
		return dinghy;
	}
}
