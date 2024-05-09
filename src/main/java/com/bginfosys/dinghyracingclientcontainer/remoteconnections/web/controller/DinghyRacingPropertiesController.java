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

package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.dto.DinghyRacingPropertiesDTO;

@RestController
@RequestMapping(value = "/dinghyracingproperties")
public class DinghyRacingPropertiesController {
	
	@Value("${dinghy-racing-httpRootURL}")
	String httpRootURL;
	
	@Value("${dinghy-racing-wsRootURL}")
	String wsRootURL;
	
	@GetMapping(value = "/connectionurls")
	public DinghyRacingPropertiesDTO getConnectionURLs() {
		DinghyRacingPropertiesDTO drps = new DinghyRacingPropertiesDTO();
		drps.setHttpRootURL(httpRootURL);
		drps.setWsRootURL(wsRootURL);
		
		return drps;
	}
}
