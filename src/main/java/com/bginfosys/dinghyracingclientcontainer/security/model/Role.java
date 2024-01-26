package com.bginfosys.dinghyracingclientcontainer.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	public Role() {};
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
