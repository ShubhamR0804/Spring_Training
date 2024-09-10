package com.techlabs.validationandexception.service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Customer;

public interface CustomerService {
	PageResponseDto<Customer> getAllCustomers(int pageNumber, int pageSize);

	Customer getCustomer(int customerid);
	Customer insertCustomer(Customer customer);
	Customer updateCustomer(Customer customer);

}
