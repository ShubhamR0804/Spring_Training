package com.techlabs.transactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.transactionmanagement.entity.Account;
import com.techlabs.transactionmanagement.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {
		// TODO Auto-generated method stub
		Account fromAccount = accountRepository.findById(fromAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid account ID"));

		Account toAccount = accountRepository.findById(toAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid account ID"));

		if (fromAccount.getBalance() < amount) {
			throw new IllegalStateException("Insufficient balance");

		}
		fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

	}
}
