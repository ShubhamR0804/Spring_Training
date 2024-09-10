package com.techlabs.jpacrudoperation.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Client")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Client {
	
	@Column(name="clientId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	@Column(name="CompanyName")
	private String companyName;
	@Column(name="registerationNumber")
	private long registerationNumber;
	@Column(name="contactPerson")
	private String contactPerson;
	@Column(name="contactEmail")
	private String contactEmail;
	@Column(name="contactNumber")
	private long contactNumber;
	@Column(name="address")
	private String address;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(name="creationDate")
	private LocalDate creationDate;
	@Column(name="kycStatus")
	@Enumerated(EnumType.STRING)
	private KycStatus kycStatus;
	
	

}
