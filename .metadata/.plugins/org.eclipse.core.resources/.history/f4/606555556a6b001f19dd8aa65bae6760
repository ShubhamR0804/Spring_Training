package com.techlabs.bank.service;

import java.util.List;

import com.techlabs.bank.entity.dto.AccountDto;
import com.techlabs.bank.entity.dto.CustomerDto;
import com.techlabs.bank.entity.dto.TransactionDto;

public interface CustomerService {

	CustomerDto addCustomer(CustomerDto customerDto);
	List<CustomerDto> getAllCustomers();
	CustomerDto getCustomerById(int customerId);
	CustomerDto updateCustomer(int customerId, CustomerDto customerDto);
	
	AccountDto addAccount(int customerId, AccountDto accountDto);
	List<TransactionDto> getAllTransactions();
	
	public boolean doesAccountBelongToCustomer(int accountId, int customerId);
}
