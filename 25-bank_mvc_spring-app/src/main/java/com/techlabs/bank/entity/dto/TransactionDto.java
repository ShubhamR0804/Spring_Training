package com.techlabs.bank.entity.dto;

import java.math.BigDecimal;

import com.techlabs.bank.entity.TransactionType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionDto {

	private int transactionId;
	@NotNull(message = "Transaction type is required")
	private TransactionType transactionType;
	@Min(value = 1, message = "Amount must be greater than 1")
	private BigDecimal amount;
	private String description;
	private int senderAccountId;
	private int destinationAccountId;

}
