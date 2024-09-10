package com.techlabs.employeedboperations.repository;

import java.util.List;

import com.techlabs.employeedboperations.entity.Employee;

public interface EmployeeRepository {
	
	List<Employee> getAllEmployees();

}
