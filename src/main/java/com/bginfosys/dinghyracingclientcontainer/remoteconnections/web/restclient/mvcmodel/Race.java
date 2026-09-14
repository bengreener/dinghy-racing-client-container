package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.RaceHalDTO;

public class Race extends AbstractMVCEntity {

	private RaceHalDTO raceHalDTO;
	
	private List<SignedUp> signedUp;
	
	private Fleet fleet;
		
	public Race(RaceHalDTO raceHalDTO, RestClient restClient) {
		super(restClient);
		this.raceHalDTO = raceHalDTO;
	}
	
	public String getName() {
		return raceHalDTO.getName();
	}
	
	public Integer getPlannedLaps() {
		return raceHalDTO.getPlannedLaps();
	}
	
	public List<SignedUp> getSignedUp() {
		if (signedUp == null) {
			signedUp = restClient.getSignedUpToByURL(raceHalDTO.getLinks().get("signedUp").getHref()).stream().map(signedUpHalDTO -> new SignedUp(signedUpHalDTO, restClient)).collect(Collectors.toList());
		}
		return signedUp;
	}
	
	public Fleet getFleet() {
		if (fleet == null) {
			fleet = new Fleet(restClient.getFleetByURL(raceHalDTO.getLinks().get("fleet").getHref()), restClient);
		}
		return fleet;
	}
	
	public Duration getDuration() {
		return raceHalDTO.getDuration();
	}
	
	public LocalDateTime getStartTime() {
		return raceHalDTO.getStartTime();
	}
}
