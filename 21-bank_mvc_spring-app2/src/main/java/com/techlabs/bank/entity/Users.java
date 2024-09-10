package com.techlabs.bank.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;

	@NotNull
	@Column(name = "username", unique = true)
	private String username;

	@NotNull
	@Column(name = "password")
	private String password;

	//@Enumerated(EnumType.STRING)
	//@NotNull
	//@Column(name = "role")
	//private String role;

	// Removed the admin relationship
	@OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	private Customers customers;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="roleId"))
	private List<Roles> roles;

}
