package com.techlabs.transactionmanagement.service;

public interface AccountService {
	
	void transferMoney(Long fromAccountId, Long toAccountId, Double amount);

}
