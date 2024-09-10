package com.techlabs.bank.service;

import java.util.List;

import com.techlabs.bank.entity.Accounts;
import com.techlabs.bank.entity.dto.AccountDto;
import com.techlabs.bank.entity.dto.CustomerDto;
import com.techlabs.bank.entity.dto.PageResponse;
import com.techlabs.bank.entity.dto.TransactionDto;

public interface CustomerService {

	CustomerDto addCustomer(CustomerDto customerDto);
	PageResponse<CustomerDto> getAllCustomers(int pageNo, int pageSize);
	CustomerDto getCustomerById(int customerId);
	CustomerDto updateCustomer(int customerId, CustomerDto customerDto);
	//This was changed from AccountDto to Accounts
	AccountDto addAccount(int customerId, Accounts accounts);
	List<TransactionDto> getAllTransactions();
	//Page<TransactionDto> getAllTransactions(int pageNumber, int pageSize);
	public boolean doesAccountBelongToCustomer(int accountId, int customerId);
}
