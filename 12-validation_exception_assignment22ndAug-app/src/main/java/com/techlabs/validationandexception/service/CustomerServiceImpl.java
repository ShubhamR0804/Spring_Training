package com.techlabs.validationandexception.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Customer;
import com.techlabs.validationandexception.exception.CustomertDoesNotExistException;
import com.techlabs.validationandexception.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public PageResponseDto<Customer> getAllCustomers(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Customer> customerPage = customerRepository.findAll(pageable);

		PageResponseDto<Customer> customerPageDto = new PageResponseDto<>();
		customerPageDto.setTotalElements((int) customerPage.getTotalElements());
		customerPageDto.setTotalPages(customerPage.getTotalPages());
		customerPageDto.setSize(customerPage.getSize());
		customerPageDto.setContent(customerPage.getContent());
		customerPageDto.setLastPage(customerPage.isLast());
		return customerPageDto;
	}

	@Override
	public Customer getCustomer(int customerid) {
		// TODO Auto-generated method stub
		Optional<Customer> dbCustomer = customerRepository.findById(customerid);
		if (!dbCustomer.isPresent()) {
			throw new CustomertDoesNotExistException();
		}
		return dbCustomer.get();
	}

	@Override
	@Transactional
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		if (!customerRepository.existsById(customer.getCustomerid())) {
			throw new CustomertDoesNotExistException();
		}
		return customerRepository.save(customer);
	}

}
