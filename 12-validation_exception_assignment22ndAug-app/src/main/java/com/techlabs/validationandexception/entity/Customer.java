package com.techlabs.validationandexception.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

	@Column(name="customerid")
	@Id                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)       
	private int customerid;
	
	@NotNull(message = "First name is required")
	@Column(name="firstname")
	private String firstname;
	
	@NotNull(message = "Last name is required")
	@Column(name="lastname")
	private String lastname;
	
	@NotNull(message = "Date of birth is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	@Column(name="dateofbirth")
	private Date dateofbirth;
	
	@NotNull(message = "Email ID is required")
	@Email(message = "Email should be valid")
	@Column(name="emailid")
	private String emailid;
	
	@NotNull(message = "Mobile number is required")
	@Min(value = 1000000000, message = "Mobile number should be a valid 10-digit number")
	@Column(name="mobilenumber")
	private long mobilenumber;
}
