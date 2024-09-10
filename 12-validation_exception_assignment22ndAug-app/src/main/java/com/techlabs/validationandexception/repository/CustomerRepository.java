package com.techlabs.validationandexception.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.validationandexception.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Page<Customer> findAll(Pageable pageable);
}
