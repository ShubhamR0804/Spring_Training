package com.techlabs.employeedboperations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.employeedboperations.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private EntityManager manager;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query=manager.createQuery("select e From Employee e",Employee.class);		
		return query.getResultList();
	}
	

}
