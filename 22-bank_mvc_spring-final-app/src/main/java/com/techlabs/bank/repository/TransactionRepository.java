package com.techlabs.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.bank.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
	
	List<Transactions> findByAccountAccountId(int accountId);

}
