package com.example.projetangularspring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.projetangularspring.entity.ERole;
import com.example.projetangularspring.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	  Optional<Role> findByName(ERole name);
}
