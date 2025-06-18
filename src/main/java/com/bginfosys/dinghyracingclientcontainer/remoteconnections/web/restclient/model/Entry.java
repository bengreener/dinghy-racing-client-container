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
package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.model;

import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Entry(Competitor helm, Dinghy dinghy) implements Comparable<Entry> {
	
	public Competitor getHelm() {
		return helm;
	}
	
	public Dinghy getDinghy() {
		return dinghy();
	}

	@Override
	public int compareTo(Entry entry) {
		int result = getDinghy().getDinghyClass().getName().compareTo(entry.getDinghy().getDinghyClass().getName());
		if (result == 0) {
			String sailNumber1 = getDinghy().getSailNumber();
			String sailNumber2 = entry.getDinghy().getSailNumber();
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
			return getDinghy().getSailNumber().compareTo(entry.getDinghy().getSailNumber());
		}
		return result;
	}
}
