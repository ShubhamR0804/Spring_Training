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
		Accounts destinationAccount = null;
		// update account balance
		if (transactionDto.getTransactionType() == TransactionType.DEBIT) {
			account.setBalance(account.getBalance().subtract(transaction.getAmount()));
			accountRepository.save(account);
		} else if (transactionDto.getTransactionType() == TransactionType.CREDIT) {
			account.setBalance(account.getBalance().add(transaction.getAmount()));
			accountRepository.save(account);
		} else if (transactionDto.getTransactionType() == TransactionType.TRANSFER) {
			// For TRANSFER, debit from source and credit to destination account
			destinationAccount = accountRepository.findById(transactionDto.getDestinationAccountId())
					.orElseThrow(() -> new ResourceNotFoundException("Destination account not found"));

			// Debit from source account
			account.setBalance(account.getBalance().subtract(transaction.getAmount()));

			// Credit to destination account
			destinationAccount.setBalance(destinationAccount.getBalance().add(transaction.getAmount()));

			// Save both accounts
			accountRepository.save(account);
			accountRepository.save(destinationAccount);

			//create another transaction record for the destination
			// account
			/*
			 * Transactions destinationTransaction = new Transactions();
			 * destinationTransaction.setTransactionType(TransactionType.CREDIT);
			 * destinationTransaction.setAmount(transactionDto.getAmount());
			 * destinationTransaction.setDescription("Transfer from account " +
			 * account.getAccountNumber());
			 * destinationTransaction.setAccount(destinationAccount);
			 * transactionRepository.save(destinationTransaction);
			 */
		}

		// save transaction
		transaction = transactionRepository.save(transaction);
		return toDto(transaction, destinationAccount);
	}

	// Overloaded 
	private TransactionDto toDto(Transactions transaction) {
		TransactionDto dto = new TransactionDto();
		dto.setTransactionId(transaction.getTransactionId());
		dto.setTransactionType(transaction.getTransactionType());
		dto.setAmount(transaction.getAmount());
		dto.setDescription(transaction.getDescription());
		dto.setAccountId(transaction.getAccount().getAccountId());
		return dto;
	}

	private TransactionDto toDto(Transactions transaction, Accounts destinationAccount) {
		TransactionDto dto = new TransactionDto();
		dto.setTransactionId(transaction.getTransactionId());
		dto.setTransactionType(transaction.getTransactionType());
		dto.setAmount(transaction.getAmount());
		dto.setDescription(transaction.getDescription());
		dto.setAccountId(transaction.getAccount().getAccountId());
		if (transaction.getTransactionType() == TransactionType.TRANSFER && destinationAccount != null)
			dto.setDestinationAccountId(destinationAccount.getAccountId());

		return dto;
	}

}
