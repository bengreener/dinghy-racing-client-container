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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DinghyHalDTO extends AbstractHalDTO {
	
	private String sailNumber;
	
	public DinghyHalDTO() {}
	
	public DinghyHalDTO(String sailNumber, Map<String, Link> links) {
		super(links);
		this.sailNumber = sailNumber;
	}
	
	public String getSailNumber() {
		return sailNumber;
	}
	
	public void setSailNumber(String sailNumber) {
		this.sailNumber = sailNumber;
	}
}
