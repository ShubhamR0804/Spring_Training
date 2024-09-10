package com.techlabs.employeedboperations.entity;

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
@Table(name="Loan")
public class Loan {

	@Column(name="loanId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loanId;
	@Column(name="loanAmount")
	private BigDecimal loanAmount;
	@Column(name="InterestRate")
	private BigDecimal interestRate;
	@Column(name="loanTerm")
	private int loanTerm;
	@Column(name="startDate")
	private LocalDate startDate;
	@Column(name="endDate")
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	@Column(name="loanStatus")
	private LoanStatus loanStatus;
	public Loan(BigDecimal loanAmount, BigDecimal interestRate, int loanTerm, LocalDate startDate, LocalDate endDate,
			LoanStatus loanStatus) {
		super();
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanStatus = loanStatus;
	}
	public Loan() {
		super();
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LoanStatus getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	
	
	
}
