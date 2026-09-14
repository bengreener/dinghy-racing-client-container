/*
 * Copyright 2022-2024 BG Information Systems Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RaceHalDTO extends AbstractHalDTO {
	
	private String name;
	
	private Integer plannedLaps;
	
	private Duration duration;
	
	private LocalDateTime plannedStartTime;
	
	private Duration startTimeOffset;
	
	public RaceHalDTO() {}
		
	public RaceHalDTO(String name, Integer plannedLaps, Duration duration, Map<String, Link> links) {
		this.name = name;
		this.plannedLaps = plannedLaps;
		this.duration = duration;
		this.links = links;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPlannedLaps() {
		return plannedLaps;
	}
	
	public void setPlannedLaps(Integer plannedLaps) {
		this.plannedLaps = plannedLaps;
	}
	
	public Duration getDuration() {
		return this.duration;
	}
	
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public void setPlannedStartTime(LocalDateTime plannedStartTime) {
		this.plannedStartTime = plannedStartTime;
	}
    
	public void setStartTimeOffset(Duration startTimeOffset) {
		this.startTimeOffset = startTimeOffset;
	}
	
	public LocalDateTime getStartTime() {
		return plannedStartTime.plus(startTimeOffset);
	}
}
