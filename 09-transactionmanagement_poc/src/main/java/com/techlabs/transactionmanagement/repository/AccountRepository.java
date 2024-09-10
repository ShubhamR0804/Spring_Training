package com.techlabs.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.transactionmanagement.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
