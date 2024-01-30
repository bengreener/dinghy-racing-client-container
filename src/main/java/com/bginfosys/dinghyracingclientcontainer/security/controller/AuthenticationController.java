package com.bginfosys.dinghyracingclientcontainer.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bginfosys.dinghyracingclientcontainer.security.facade.AuthenticationFacade;
import com.bginfosys.dinghyracingclientcontainer.security.model.Roles;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

	@Autowired
	AuthenticationFacade authenticationFacade;
	
	@GetMapping(value = "/roles")
	public Roles getCurrentPrinciplesRoles() {
		Roles roles = new Roles();
		roles.setRoles(authenticationFacade.principalRoles());
		return roles;
	}
}
