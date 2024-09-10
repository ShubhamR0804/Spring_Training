package com.techlabs.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="students")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rollNumber")
	private int rollNumber;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address-id")
	private Address address;
	

}
