package com.techlabs.employeedboperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.employeedboperations.entity.Customer;
import com.techlabs.employeedboperations.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// GET all customers
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	// GET customer by ID
	@GetMapping("/{customerid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerid) {
		return ResponseEntity.ok(customerService.getCustomer(customerid));
	}

	// POST a new customer
	@PostMapping("/addCustomers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.insertCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	// PUT to update an existing customer
	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
