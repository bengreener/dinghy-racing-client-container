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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Competitor;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Dinghy;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.DinghyClass;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Entry;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Race;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {
	
	@Value("${dinghy-racing-httpRootURL}")
	String httpRootURL;
	
	private RestTemplate restTemplate;
	
	public RestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Race getRaceById(Long raceId) {
		Race race = null;
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity<String> response = restTemplate.getForEntity(httpRootURL + "/races/" + raceId.toString(), String.class);
		JsonNode root;
		try {
			root = objectMapper.readTree(response.getBody());
			List<Entry> signedUp = getSignedUpByURL(root.path("_links").path("signedUp").path("href").asText());
			race = new Race(root.path("name").asText(), root.path("plannedLaps").asLong(), signedUp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get entries
		
		return race;
	}
	
	public List<Entry> getSignedUpByURL(String url) {
		List<Entry> signedUp = new ArrayList<Entry>();
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		JsonNode root;
		try {
			root = objectMapper.readTree(response.getBody());
			JsonNode entries = root.path("_embedded").path("entries");
			if (entries.isArray()) {
				for (JsonNode entryNode : entries) {
					Competitor helm = getCompetitorByURL(entryNode.path("_links").path("helm").path("href").asText());
					Dinghy dinghy = getDinghyByURL(entryNode.path("_links").path("dinghy").path("href").asText());
					signedUp.add(new Entry(helm, dinghy));
				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signedUp.sort(null);
		return signedUp;
	}
	
	public Competitor getCompetitorByURL(String url) {
		return restTemplate.getForObject(url, Competitor.class);
	}
	
	public Dinghy getDinghyByURL(String url) {
		Dinghy dinghy = null;
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		JsonNode root;
		try {
			root = objectMapper.readTree(response.getBody());
			String sailNumber = root.get("sailNumber").asText(); 
			DinghyClass dinghyClass = getDinghyClassByURL(root.path("_links").path("dinghyClass").path("href").asText());
			dinghy = new Dinghy(sailNumber, dinghyClass);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dinghy;
	}
	
	public DinghyClass getDinghyClassByURL(String url) {
		return restTemplate.getForObject(url, DinghyClass.class);
	}
}
