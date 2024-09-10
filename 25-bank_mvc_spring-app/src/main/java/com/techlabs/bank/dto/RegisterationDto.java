package com.techlabs.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class RegisterationDto {
	
	private String username;
	private String password;
	private String role;
	

}
