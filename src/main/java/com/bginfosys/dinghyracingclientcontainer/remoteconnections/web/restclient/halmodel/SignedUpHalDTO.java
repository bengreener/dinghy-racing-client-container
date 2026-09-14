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
public class SignedUpHalDTO extends AbstractHalDTO {

	private Duration correctedTime;
	
	private Integer position;
		
	public SignedUpHalDTO() {}
	
	public SignedUpHalDTO(Duration correctedTime, Integer position, Map<String, Link> links) {
		super(links);
		this.correctedTime = correctedTime;
		this.position = position;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Duration getCorrectedTime() {
		if (correctedTime.equals(Duration.ofSeconds((long)Double.POSITIVE_INFINITY))) {
			return Duration.ZERO;
		}
		return correctedTime;
	}
	
	public void setCorrectedTime(Duration correctedTime) {
		this.correctedTime = correctedTime;
	}
	
}
