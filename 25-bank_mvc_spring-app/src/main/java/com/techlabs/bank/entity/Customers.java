package com.techlabs.bank.entity;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	@Column(name="firstName")
	@NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "First name should contain only letters and spaces")
	private String firstName;
	@Column(name="lastName")
	@NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Last name should contain only letters and spaces")
	private String lastName;
	@Column(name="email", unique = true)
	@NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
        message = "Email must be valid and follow the standard format (e.g., user@example.com)"
    )
	private String email;
	@Column(name = "phone", unique = true, length = 10)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
	private String phone;
	@Column(name="address")
	private String address;

	@Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusType status;
    
    @Column(name="KycStatus")
    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;
	
	@OneToOne
	@JoinColumn(name="user-id", referencedColumnName = "userId")
	private Users user;
	
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	private List<Accounts> accounts; //= new ArrayList<>();
	
}
