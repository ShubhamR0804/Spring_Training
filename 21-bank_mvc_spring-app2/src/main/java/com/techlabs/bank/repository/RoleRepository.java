package com.techlabs.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.bank.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

	Optional<Roles> findByRoleName(String role);
}
