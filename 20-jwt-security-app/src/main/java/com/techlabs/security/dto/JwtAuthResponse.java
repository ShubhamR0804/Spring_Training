package com.techlabs.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtAuthResponse {

	private String accessToken;
	private String tokenType="Bearer";
	
}
