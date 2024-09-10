package com.techlabs.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class RegisterationDto {
	
	private String userName;
	private String password;
	private String role;
	

}
