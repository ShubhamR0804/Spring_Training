package com.techlabs.assignmentmapping.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="salary")
public class Salary {
	
	@Column(name="salaryId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salaryId;
	@Column(name="salaryMonth")
	private String salaryMonth;
	@Column(name="grossSalary")
	private BigDecimal grossSalary;
	@Column(name="deductions")
	private BigDecimal deductions;
	@Column(name="netSalary")
	private BigDecimal netSalary;
	@Column(name="paymentDate")
	private LocalDate paymentDate;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy = "salary",cascade = CascadeType.ALL)
	private List<SalaryTransaction> salaryTransaction;
	

}
