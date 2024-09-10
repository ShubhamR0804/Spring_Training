package com.techlabs.employeedboperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.employeedboperations.entity.Customer;
import com.techlabs.employeedboperations.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

	 @Autowired 
	 private EntityManager entityManager; 
	 @Autowired 
	 private CustomerRepository customerRepository; 
	 
	 @Override 
	 public List<Customer> getAllCustomers() { 
	  // TODO Auto-generated method stub 
	  return customerRepository.getAllCustomer(); 
	 } 
	 
	 @Override 
	 public Customer getCustomer(int customerid) { 
	  // TODO Auto-generated method stub 
	  return customerRepository.getCustomer(customerid); 
	 
	 } 
	 
	 @Override 
	 @Transactional 
	 public Customer insertCustomer(Customer customer) { 
	  // TODO Auto-generated method stub 
	  return customerRepository.insertCustomer(customer); 
	 } 
	 
	 @Override 
	 @Transactional 
	 public Customer updateCustomer(Customer customer) { 
	  // TODO Auto-generated method stub 
	  return customerRepository.updateCustomer(customer); 
	 } 

}
