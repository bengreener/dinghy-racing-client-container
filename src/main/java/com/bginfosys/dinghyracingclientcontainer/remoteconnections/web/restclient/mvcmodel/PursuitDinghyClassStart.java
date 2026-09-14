package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.time.Duration;
import java.time.LocalDateTime;

public class PursuitDinghyClassStart {

	private DinghyClass dinghyClass;
	
	private LocalDateTime startTime;
	
	private Duration startTimeOffset;
	
	public PursuitDinghyClassStart(DinghyClass dinghyClass, LocalDateTime startTime, Duration startTimeOffset) {
		this.dinghyClass = dinghyClass;
		this.startTime = startTime;
		this.startTimeOffset = startTimeOffset;
	}
	
	public DinghyClass getDinghyClass() {
		return dinghyClass;
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public Duration getStartTimeOffset() {
		return startTimeOffset;
	}
	
}
