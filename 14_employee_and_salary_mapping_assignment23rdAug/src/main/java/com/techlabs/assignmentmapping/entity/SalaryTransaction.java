package com.techlabs.assignmentmapping.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="SalaryTransaction")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class SalaryTransaction {
	
	@Column(name="transactionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Column(name="transactionDate")
	private LocalDate transactionDate;
	@Column(name="amount")
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="salary_id")
	private Salary salary;
	

}
