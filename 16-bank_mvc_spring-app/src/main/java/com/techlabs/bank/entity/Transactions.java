package com.techlabs.bank.entity;

import java.math.BigDecimal;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="transactions")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionId")
	private int transactionId;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="transactionType")
	private TransactionType transactionType;
	@NotNull
	@Positive
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "accountId")
	private Accounts account;

	@ManyToOne
	@JoinColumn(name = "admin_id", referencedColumnName = "adminId")
	private Admins admin;
}
