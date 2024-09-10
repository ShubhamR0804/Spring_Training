package com.techlabs.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.security.entity.Customer;
import com.techlabs.security.service.CustomerService;
@RestController
@RequestMapping("/customerapp")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@GetMapping("/customers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers()); 
	}
	@PreAuthorize("hasRole('CUSTOMER')")
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable int customerId){
		return ResponseEntity.ok(customerService.getCustomerById(customerId)); 
	}
	
	
}
