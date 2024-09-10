package com.techlabs.bank.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="accounts")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Accounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accountId")
	private int accountId;
	@NotNull
	@Column(name="accountNumber",unique = true)
	private String accountNumber;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="accountType")
	private AccountType accountType;
	@NotNull
	@PositiveOrZero
	@Column(name="balance")
	private BigDecimal balance;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
	private Customers customer;
	
	@OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	private List<Transactions> transactions;
}
