package com.techlabs.bank.entity;

import java.math.BigDecimal;
import java.security.SecureRandom;
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
	@Column(name="accountNumber", nullable= false, unique=true)
	@NotNull(message = "Account number is required")
	private long accountNumber;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="accountType")
	@NotNull(message = "Account type is required")
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
	private String generateRandomAccountNumber() {
	    SecureRandom random = new SecureRandom();
	    StringBuilder accountNumberBuilder = new StringBuilder(10);
	    
	    for (int i = 0; i < 10; i++) {
	        accountNumberBuilder.append(random.nextInt(10)); // Append a random digit (0-9)
	    }
	    
	    return accountNumberBuilder.toString();
	}
}
