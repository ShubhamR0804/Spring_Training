package com.techlabs.jpacrudoperation.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Column(name="employeeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="phoneNumber")
	private long phoneNumber;
	@Column(name="email")
	private String email;
	@Column(name="position")
	private String position;
	@Column(name="hireDate")
	private LocalDate hireDate;
	@Column(name="salary")
	private BigDecimal salary;
	@Column(name="bankAccountNumber")
	private String bankAccountNumber;
	@Column(name="bankIfscNumber")
	private String bankIfscNumber;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	

}
