package com.techlabs.bank.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;
	@NotNull
	@Column(name = "username", unique=true)
	private String username;
	@NotNull
	@Column(name = "password")
	private String password;
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "role")
	private Role role;
	
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Admins admins;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Customers customers;
	
}
