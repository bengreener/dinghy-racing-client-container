package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model.Race;

@Controller
public class LapSheetController {
	
	@Autowired
	private RestClient restClient;
		
	@GetMapping("/lap-sheet/{id}") 
	public String lapSheet(@PathVariable("id") Long id, Model model) {
		Race race = restClient.getRaceById(id);
		restClient.getSignedupByURL(race.getSignedUpURL());
		model.addAttribute("name", race.getName());
		return "lap-sheet";
	}

}
