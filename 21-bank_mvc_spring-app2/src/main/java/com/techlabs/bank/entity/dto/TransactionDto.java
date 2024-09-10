package com.techlabs.bank.entity.dto;

import java.math.BigDecimal;

import com.techlabs.bank.entity.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionDto {
	
	 private int transactionId;
	    private TransactionType transactionType;
	    private BigDecimal amount;
	    private String description;
	    private int accountId;
	    private int destinationAccountId;

}
