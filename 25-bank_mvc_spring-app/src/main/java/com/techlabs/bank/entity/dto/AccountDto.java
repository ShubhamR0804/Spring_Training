package com.techlabs.bank.entity.dto;

import java.math.BigDecimal;

import com.techlabs.bank.entity.AccountType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto {
	
	private int accountId;
	@NotNull(message = "Account number is required")
    @Pattern(regexp = "\\d{10}", message = "Account number must be exactly 10 digits")
    private long accountNumber;
	@NotNull(message = "Account type is required")
    private AccountType accountType;
    private BigDecimal balance;

}
