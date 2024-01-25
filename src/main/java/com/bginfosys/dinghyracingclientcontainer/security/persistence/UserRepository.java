package com.bginfosys.dinghyracingclientcontainer.security.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bginfosys.dinghyracingclientcontainer.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
}
