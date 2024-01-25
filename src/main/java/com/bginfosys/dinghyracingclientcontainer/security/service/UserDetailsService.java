package com.bginfosys.dinghyracingclientcontainer.security.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), new ArrayList<SimpleGrantedAuthority>());
	}
}
