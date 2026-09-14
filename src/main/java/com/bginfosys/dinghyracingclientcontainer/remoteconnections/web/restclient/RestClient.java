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
package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.CompetitorHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.DinghyHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.DinghyClassHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.EntryHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.FleetHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.RaceHalDTO;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.SignedUpHalDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class RestClient {
	
	@Value("${dinghy-racing-httpRootURL}")
	String httpRootURL;
	
	private RestTemplate restTemplate;
	
	public RestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getHttpRootURL() {
		return httpRootURL;
	}

	public RaceHalDTO getRaceById(Long raceId) {
		return restTemplate.getForObject(httpRootURL + "/races/" + raceId.toString(), RaceHalDTO.class);
	}
	
	public EntryHalDTO getEntryByURL(String url) {
		return restTemplate.getForObject(url, EntryHalDTO.class);
	}
	
	public List<SignedUpHalDTO> getSignedUpToByURL(String url) {
		List<SignedUpHalDTO> signedUpTo = new ArrayList<SignedUpHalDTO>();
		ObjectMapper objectMapper = JsonMapper.builder()
				.addModule(new JavaTimeModule())
				.build();
		String json = restTemplate.getForEntity(url, String.class).getBody();
		try {
			TypeReference<List<SignedUpHalDTO>> typeReference = new TypeReference<List<SignedUpHalDTO>>() {};
			JsonNode rootNode = objectMapper.readTree(json);
			JsonNode signedUpsNode = rootNode.path("_embedded").path("signedUps");
			signedUpTo = objectMapper.convertValue(signedUpsNode, typeReference);
		}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return signedUpTo;
	}
	
	public SignedUpHalDTO getSignedUpByURL(String url) {
		return restTemplate.getForObject(url, SignedUpHalDTO.class);
	}
	
	public CompetitorHalDTO getCompetitorByURL(String url) {
		return restTemplate.getForObject(url, CompetitorHalDTO.class);
	}
	
	public DinghyHalDTO getDinghyByURL(String url) {
		return restTemplate.getForObject(url, DinghyHalDTO.class);
	}
	
	public DinghyClassHalDTO getDinghyClassByURL(String url) {
		return restTemplate.getForObject(url, DinghyClassHalDTO.class);
	}
	
	public List<DinghyClassHalDTO> getDinghyClassesByURL(String url) {
		List<DinghyClassHalDTO> dinghyClasses = new ArrayList<DinghyClassHalDTO>();
		ObjectMapper objectMapper = JsonMapper.builder()
				.addModule(new JavaTimeModule())
				.build();
		String json = restTemplate.getForEntity(url, String.class).getBody();
		try {
			TypeReference<List<DinghyClassHalDTO>> typeReference = new TypeReference<List<DinghyClassHalDTO>>() {};
			JsonNode rootNode = objectMapper.readTree(json);
			JsonNode dinghyClassesNode = rootNode.path("_embedded").path("dinghyClasses");
			dinghyClasses = objectMapper.convertValue(dinghyClassesNode, typeReference);
		}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return dinghyClasses;
	}
	
	public FleetHalDTO getFleetByURL(String url) {
		return restTemplate.getForObject(url, FleetHalDTO.class);
	}
}
