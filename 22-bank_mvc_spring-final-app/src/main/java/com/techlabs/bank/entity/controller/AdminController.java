package com.techlabs.bank.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.bank.entity.dto.AccountDto;
import com.techlabs.bank.entity.dto.CustomerDto;
import com.techlabs.bank.entity.dto.TransactionDto;
import com.techlabs.bank.service.CustomerService;
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomers")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/customers/{customerId}/addaccounts")
    public ResponseEntity<AccountDto> addAccount(@PathVariable int customerId, @RequestBody AccountDto accountDto) {
        AccountDto createdAccount = customerService.addAccount(customerId, accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/getcustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/gettransactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = customerService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
