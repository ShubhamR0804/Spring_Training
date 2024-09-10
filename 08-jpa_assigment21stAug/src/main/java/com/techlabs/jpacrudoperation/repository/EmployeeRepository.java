package com.techlabs.jpacrudoperation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.jpacrudoperation.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Page<Employee> findByFirstName(String fname,Pageable pageable);
	Page<Employee> findByLastName(String lname,Pageable pageable);
	Page<Employee> findByPosition(String position,Pageable pageable);
	

}
