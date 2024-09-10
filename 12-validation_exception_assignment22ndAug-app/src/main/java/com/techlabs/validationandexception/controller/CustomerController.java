package com.techlabs.validationandexception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Customer;
import com.techlabs.validationandexception.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customerapp")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ResponseEntity<PageResponseDto<Customer>> getAllCustomers(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "10") int pageSize) {
		PageResponseDto<Customer> customers = customerService.getAllCustomers(pageNumber, pageSize);
		return ResponseEntity.ok(customers);
	}

	@GetMapping("/{customerid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerid) {
		Customer customer = customerService.getCustomer(customerid);
		return ResponseEntity.ok(customer);
	}

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		Customer newCustomer = customerService.insertCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
}
