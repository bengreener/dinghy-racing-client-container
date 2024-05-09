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

package com.bginfosys.dinghyracingclientcontainer.security.facade;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {	

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public UserDetails getPrincipal() {
		return (UserDetails) getAuthentication().getPrincipal();
	}

	public List<String> principalRoles() {
		return getPrincipal().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	}
	
	public String principalRolesToString() {
		return getPrincipal().getAuthorities().stream().map(GrantedAuthority::getAuthority).reduce("", (string1, string2) -> string1 != "" ? string1 + ";" + string2 : string2);
	}
	
	

}