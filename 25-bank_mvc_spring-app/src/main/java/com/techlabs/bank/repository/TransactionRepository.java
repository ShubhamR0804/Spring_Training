package com.techlabs.bank.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.bank.entity.Transactions;

import jakarta.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
	
	List<Transactions> findByAccountAccountId(int accountId);
	//Page<Transaction> findAll(Pageable pageable);
}
