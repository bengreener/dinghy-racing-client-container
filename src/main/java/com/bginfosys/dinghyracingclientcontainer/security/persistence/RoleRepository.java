package com.bginfosys.dinghyracingclientcontainer.security.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bginfosys.dinghyracingclientcontainer.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
