package com.techlabs.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.security.entity.Customer;
import com.techlabs.security.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(customerId);
		return customer.get();
	}

}
