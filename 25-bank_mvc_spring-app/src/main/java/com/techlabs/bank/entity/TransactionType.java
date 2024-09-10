package com.techlabs.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType {
	
	DEBIT,
	CREDIT,
	TRANSFER

}
