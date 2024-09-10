package com.techlabs.jpacrudoperation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.jpacrudoperation.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	Page<Client> findByCompanyName(String companyName, Pageable pageable);

}
