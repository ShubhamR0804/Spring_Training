package com.techlabs.transactionmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.transactionmanagement.service.AccountService;

@RestController
@RequestMapping("/accountapp")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/transfer")
	public String transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId,@RequestParam Double amount) {

		accountService.transferMoney(fromAccountId, toAccountId, amount);
		return "Transfer successful";
	}

}
