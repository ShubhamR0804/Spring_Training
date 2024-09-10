package com.techlabs.bank.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.bank.dto.JwtAuthResponse;
import com.techlabs.bank.dto.LoginDto;
import com.techlabs.bank.dto.RegisterationDto;
import com.techlabs.bank.entity.Users;
import com.techlabs.bank.service.AuthService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private AuthService authService;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/register")
	public ResponseEntity<Users> register(@RequestBody RegisterationDto registerDto){
		return ResponseEntity.ok(authService.register(registerDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
		String token=authService.login(loginDto);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		return ResponseEntity.ok(jwtAuthResponse);
	}

}
