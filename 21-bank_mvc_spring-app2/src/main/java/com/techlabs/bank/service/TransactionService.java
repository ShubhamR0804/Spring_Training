package com.techlabs.bank.service;

import java.util.List;

import com.techlabs.bank.entity.dto.TransactionDto;

public interface TransactionService {
	
	List<TransactionDto> getPassbook(int accountId);
	TransactionDto createTransaction(TransactionDto transactionDto);
	

}
