package com.techlabs.validationandexception.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.validationandexception.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	Page<Loan> findAll(Pageable pageable);
}
