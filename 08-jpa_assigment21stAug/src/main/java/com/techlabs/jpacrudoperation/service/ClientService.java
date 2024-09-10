package com.techlabs.jpacrudoperation.service;

import org.springframework.data.domain.Page;
import com.techlabs.jpacrudoperation.entity.Client;

public interface ClientService {
	
	Page<Client> getAllClients(int pageSize,int pageNumber);
	Page<Client> getClientsByName(String companyName, int pageSize, int pageNumber);
	

}
