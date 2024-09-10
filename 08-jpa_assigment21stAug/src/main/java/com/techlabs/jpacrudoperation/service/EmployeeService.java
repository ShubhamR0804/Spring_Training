package com.techlabs.jpacrudoperation.service;

import org.springframework.data.domain.Page;

import com.techlabs.jpacrudoperation.entity.Employee;

public interface EmployeeService {

	Page<Employee> getAllEmployees(int pageSize, int pageNumber);

	Page<Employee> getEmployeeByFirstName(String firstName, int pageSize, int pageNumber);

	Page<Employee> getEmployeeByLastName(String lastName, int pageSize, int pageNumber);

	Page<Employee> getEmployeePosition(String position, int pageSize, int pageNumber);
}
