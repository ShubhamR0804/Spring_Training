package com.techlabs.security.service;

import java.util.List;

import com.techlabs.security.entity.Customer;

public interface CustomerService {
List<Customer> getAllCustomers();
Customer getCustomerById(int customerId);
}
