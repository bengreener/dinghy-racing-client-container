package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;

public class PursuitRaceStart extends AbstractMVCEntity{

	private Race race;
		
	public PursuitRaceStart(Race race, RestClient restClient) {
		super(restClient);
		this.race = race;
	}
	
	public List<PursuitDinghyClassStart> getDinghyClassStarts() {
		List<DinghyClass> sortedDinghyClasses = race.getFleet().getDinghyClasses().stream()
				.sorted((DinghyClass dc1, DinghyClass dc2) -> dc1.getPortsmouthNumber().compareTo(dc2.getPortsmouthNumber()) * -1).collect(Collectors.toList());
		DinghyClass baseClass = sortedDinghyClasses.get(0);
		return sortedDinghyClasses.stream().map(dinghyClass -> {
			// race.duration - (race.duration x dinghyClass.portsmouthNumber / baseClass.portsmouthNumber)
			Duration startOffset = race.getDuration().minus(race.getDuration().multipliedBy(dinghyClass.getPortsmouthNumber().longValue()).dividedBy(baseClass.getPortsmouthNumber().longValue()));
			if (startOffset.getNano() > 0) {
				// raise start offset to next full second; this has the opposite effect of dropping nanos from time sailed for a handicap race
				startOffset = startOffset.minus(Duration.ofNanos(startOffset.getNano())).plus(Duration.ofSeconds(1L));
			}
			return new PursuitDinghyClassStart(dinghyClass, race.getStartTime().plus(startOffset), startOffset);
		}).collect(Collectors.toList());
	}
}
