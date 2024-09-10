package com.techlabs.assignmentmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.assignmentmapping.entity.SalaryTransaction;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Integer>{

}
