package com.bginfosys.dinghyracingclientcontainer.security.facade;

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

	public String principalRolesToString() {
		return getPrincipal().getAuthorities().stream().map(GrantedAuthority::getAuthority).reduce("", (string1, string2) -> string1 != "" ? string1 + ";" + string2 : string2);
	}

}