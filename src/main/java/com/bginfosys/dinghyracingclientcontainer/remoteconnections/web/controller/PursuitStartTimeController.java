package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel.PursuitRaceStart;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel.Race;

@Controller
public class PursuitStartTimeController {

	private RestClient restClient;
	
	public PursuitStartTimeController(RestClient restClient) {
		this.restClient = restClient;
	}
	
	@GetMapping("/pursuit-start/{id}")
	public String startTimes(@PathVariable("id") Long id, Model model) {
		Race race = new Race(restClient.getRaceById(id), restClient);
		PursuitRaceStart pursuitRaceStart = new PursuitRaceStart(race, restClient);
				
		model.addAttribute("race", race);
		model.addAttribute("dinghyClassStarts", pursuitRaceStart.getDinghyClassStarts());
		return "pursuit-start-times";
	}
	
}
