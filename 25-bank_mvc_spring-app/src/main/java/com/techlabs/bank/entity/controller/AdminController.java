package com.techlabs.bank.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.bank.entity.Accounts;
import com.techlabs.bank.entity.dto.AccountDto;
import com.techlabs.bank.entity.dto.CustomerDto;
import com.techlabs.bank.entity.dto.PageResponse;
import com.techlabs.bank.entity.dto.TransactionDto;
import com.techlabs.bank.service.CustomerService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private CustomerService customerService;
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<AccountDto> addAccount(@PathVariable int customerId, @RequestBody Accounts accounts) {
        AccountDto createdAccount = customerService.addAccount(customerId, accounts);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
	@PreAuthorize("hasRole('ADMIN')")	
    @GetMapping("/customers")
    public ResponseEntity<PageResponse<CustomerDto>> getAllCustomers(@RequestParam(name="pageNo") int pageNo,@RequestParam(name="pageSize") int pageSize) {
		return ResponseEntity.ok(customerService.getAllCustomers(pageNo, pageSize));
		/*
		 * List<CustomerDto> customers = customerService.getAllCustomers(); return new
		 * ResponseEntity<>(customers, HttpStatus.OK);
		 */
    }
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/customers/transactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = customerService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/customers/transactions")
//	public ResponseEntity<Page<TransactionDto>> getAllTransactions(
//	    @RequestParam(defaultValue = "0") int pageNumber,
//	    @RequestParam(defaultValue = "10") int pageSize) {
//	    
//	    // Call service to get paginated transactions
//	    Page<TransactionDto> transactions = customerService.getAllTransactions(pageNumber, pageSize);
//	    return new ResponseEntity<>(transactions, HttpStatus.OK);
//	}

}
