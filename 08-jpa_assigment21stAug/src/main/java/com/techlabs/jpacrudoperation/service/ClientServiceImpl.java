package com.techlabs.jpacrudoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.jpacrudoperation.entity.Client;
import com.techlabs.jpacrudoperation.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Page<Client> getAllClients(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return clientRepository.findAll(pageable);
	}

	@Override
	public Page<Client> getClientsByName(String companyName, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return clientRepository.findByCompanyName(companyName, pageable);
	}

}
