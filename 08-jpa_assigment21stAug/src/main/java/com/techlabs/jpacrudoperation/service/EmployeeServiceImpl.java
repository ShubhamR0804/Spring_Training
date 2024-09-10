package com.techlabs.jpacrudoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.techlabs.jpacrudoperation.entity.Employee;
import com.techlabs.jpacrudoperation.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public Page<Employee> getAllEmployees(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findAll(pageable);
	}

	@Override
	public Page<Employee> getEmployeeByFirstName(String firstName, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findByFirstName(firstName, pageable);
	}

	@Override
	public Page<Employee> getEmployeeByLastName(String lastName, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findByLastName(lastName, pageable);
	}

	@Override
	public Page<Employee> getEmployeePosition(String position, int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return employeeRepository.findByPosition(position, pageable);
	}

}
