package com.techlabs.security.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="User")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="roleId"))
	private List<Role> roles;
	
	
}
