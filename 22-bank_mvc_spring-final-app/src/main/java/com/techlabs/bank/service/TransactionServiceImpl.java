package com.techlabs.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.bank.entity.Accounts;
import com.techlabs.bank.entity.TransactionType;
import com.techlabs.bank.entity.Transactions;
import com.techlabs.bank.entity.dto.TransactionDto;
import com.techlabs.bank.exception.ResourceNotFoundException;
import com.techlabs.bank.repository.AccountRepository;
import com.techlabs.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;

	public List<TransactionDto> getPassbook(int accountId) {
		List<Transactions> transactions = transactionRepository.findByAccountAccountId(accountId);
		return transactions.stream().map(this::toDto).collect(Collectors.toList());
	}

	public TransactionDto createTransaction(TransactionDto transactionDto) {
		Accounts account = accountRepository.findById(transactionDto.getAccountId())
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
		Transactions transaction = new Transactions();
		// map dto fields to entity
		transaction.setTransactionType(transactionDto.getTransactionType());
		transaction.setAmount(transactionDto.getAmount());
		transaction.setDescription(transactionDto.getDescription());
		transaction.setAccount(account);
		// update account balance
		if (transactionDto.getTransactionType() == TransactionType.DEBIT) {
			account.setBalance(account.getBalance().subtract(transaction.getAmount()));
		} else if (transactionDto.getTransactionType() == TransactionType.CREDIT) {
			account.setBalance(account.getBalance().add(transaction.getAmount()));
		}
		accountRepository.save(account);
		// save transaction
		transaction = transactionRepository.save(transaction);
		return toDto(transaction);
	}

	private TransactionDto toDto(Transactions transaction) {
		TransactionDto dto = new TransactionDto();
		dto.setTransactionId(transaction.getTransactionId());
		dto.setTransactionType(transaction.getTransactionType());
		dto.setAmount(transaction.getAmount());
		dto.setDescription(transaction.getDescription());
		dto.setAccountId(transaction.getAccount().getAccountId());
		return dto;
	}

}
