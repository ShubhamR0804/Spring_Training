package com.techlabs.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.bank.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {

}
