package com.techlabs.assignmentmapping.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Employee {
	
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private long phoneNumber;
	
	private String email;
	
	private String position;
	
	private LocalDate hireDate;
	
	private BigDecimal salary;
	@Enumerated(EnumType.STRING)
	private Status status;
	

}
