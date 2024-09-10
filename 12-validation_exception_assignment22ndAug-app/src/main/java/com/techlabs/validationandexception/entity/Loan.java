package com.techlabs.validationandexception.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loans")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Loan {

	@Column(name = "loanid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanid;

	@Column(nullable = false)
	@Min(value = 1, message = "Loan amount must be greater than 0")
	private int loanamount;

	@Column(nullable = false)
	private double interestrate;

	@Column(nullable = false)
	@Min(value = 1, message = "Loan term must be greater than 0")
	private int loanterm;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date startdate;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private LoanStatus loanstatus;

}
