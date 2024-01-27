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