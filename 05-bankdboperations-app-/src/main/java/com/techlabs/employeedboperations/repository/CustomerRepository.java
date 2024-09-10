package com.techlabs.employeedboperations.repository;

import java.util.List;

import com.techlabs.employeedboperations.entity.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomer(); 
	 
	 Customer getCustomer(int customerid); 
	 
	 Customer insertCustomer(Customer customer); 
	 
	 Customer updateCustomer(Customer customer);

}
