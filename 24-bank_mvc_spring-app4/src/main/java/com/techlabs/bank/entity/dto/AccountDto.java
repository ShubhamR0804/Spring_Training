package com.techlabs.bank.entity.dto;

import com.techlabs.bank.entity.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import com.techlabs.bank.entity.AccountType;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto {
	
	private int accountId;
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal balance;

}
