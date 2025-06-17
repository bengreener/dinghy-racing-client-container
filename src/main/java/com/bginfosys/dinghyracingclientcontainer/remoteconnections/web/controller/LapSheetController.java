package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LapSheetController {
	
	@GetMapping("/lap-sheet") 
	public String lapSheet() {
		return "lap-sheet";
	}

}
