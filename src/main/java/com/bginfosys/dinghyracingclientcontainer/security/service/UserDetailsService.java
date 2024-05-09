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

package com.bginfosys.dinghyracingclientcontainer.security.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bginfosys.dinghyracingclientcontainer.security.model.Role;
import com.bginfosys.dinghyracingclientcontainer.security.model.User;
import com.bginfosys.dinghyracingclientcontainer.security.persistence.UserRepository;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> user = userRepository.findByUsername(username);
		
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), getAuthorities(user.get().getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName())).collect(Collectors.toList());
	}
}
