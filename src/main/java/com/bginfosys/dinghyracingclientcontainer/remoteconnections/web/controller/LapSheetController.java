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

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel.Race;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel.SignedUp;

@Controller
public class LapSheetController {
	
	@Autowired
	private RestClient restClient;
		
	@GetMapping("/lap-sheet/{id}") 
	public String lapSheet(@PathVariable("id") Long id, Model model) {
		Race race = new Race(restClient.getRaceById(id), restClient);
		List<SignedUp> signedUp = race.getSignedUp();
		
		Comparator<SignedUp> byClassAndSailNumber = (SignedUp su1, SignedUp su2) -> {
			int result = su1.getEntry().getDinghy().getDinghyClass().getName().compareTo(su2.getEntry().getDinghy().getDinghyClass().getName());
			if (result == 0) {
				String sailNumber1 = su1.getEntry().getDinghy().getSailNumber();
				String sailNumber2 = su2.getEntry().getDinghy().getSailNumber();
				// if both sail numbers are numeric sort them in numeric order
				Pattern pattern = Pattern.compile("^\\d+$");
				if (pattern.matcher(sailNumber1).matches() && pattern.matcher(sailNumber2).matches()) {
					Integer intSailNumber1 = Integer.parseInt(sailNumber1);
					Integer intSailNumber2 = Integer.parseInt(sailNumber2);
					return intSailNumber1.compareTo(intSailNumber2);
				}
				// sort numeric values first
				if (pattern.matcher(sailNumber1).matches()) {
					return -1;
				}
				if (pattern.matcher(sailNumber2).matches()) {
					return 1;
				}
				return su1.getEntry().getDinghy().getSailNumber().compareTo(su2.getEntry().getDinghy().getSailNumber());
			}
			return result;
		};
		
		signedUp.sort(byClassAndSailNumber);
		model.addAttribute("race", race);
		model.addAttribute("signedUp", signedUp);
		return "lap-sheet";
	}
}
