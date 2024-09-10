package com.techlabs.jpacrudoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.jpacrudoperation.entity.Client;
import com.techlabs.jpacrudoperation.service.ClientService;

@RestController
@RequestMapping("/clientapp")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<Page<Client>> getAllClients(@RequestParam(required = false) String companyName, @RequestParam int pageSize, @RequestParam int pageNumber){
		if(companyName!=null)
			return ResponseEntity.ok(clientService.getClientsByName(companyName,pageSize,pageNumber));
		return ResponseEntity.ok(clientService.getAllClients(pageSize,pageNumber));
		
	}
}
