package com.techlabs.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.bank.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{

}
