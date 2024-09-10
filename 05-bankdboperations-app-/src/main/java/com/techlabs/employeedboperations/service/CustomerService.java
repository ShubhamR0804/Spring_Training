package com.techlabs.employeedboperations.service;

import java.util.List;

import com.techlabs.employeedboperations.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomer(int customerid);

	Customer insertCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

}
