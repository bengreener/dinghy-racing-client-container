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
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryHalDTO extends AbstractHalDTO {
	
	private Duration sumOfLapTimes;
	
	private String scoringAbbreviation;
	
	private Integer lapsSailed;
	
	public EntryHalDTO() {}
	
	public EntryHalDTO(Duration sumOfLapTimes, String scoringAbbreviation, Integer lapsSailed, Map<String, Link> links) {
		super(links);
		this.sumOfLapTimes = sumOfLapTimes;
		this.scoringAbbreviation = scoringAbbreviation;
		this.lapsSailed = lapsSailed;
	}
	
	public Duration getSumOfLapTimes() {
		return sumOfLapTimes;
	}
	
	public void setSumOfLapTimes(Duration sumOfLapTimes) {
		this.sumOfLapTimes = sumOfLapTimes;
	}
	
	public String getScoringAbbreviation() {
		return scoringAbbreviation;
	}
	
	public void setScoringAbbreviation(String scoringAbbreviation) {
		this.scoringAbbreviation = scoringAbbreviation;
	}
	
	public Integer getLapsSailed() {
		return lapsSailed;
	}
	
	public void setLapsSailed(Integer lapsSailed) {
		this.lapsSailed = lapsSailed;
	}
	
}
