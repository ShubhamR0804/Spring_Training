package com.techlabs.bank.service;

import com.techlabs.bank.dto.LoginDto;
import com.techlabs.bank.dto.RegisterationDto;
import com.techlabs.bank.entity.Users;

public interface AuthService {
	Users register(RegisterationDto registeration);

	String login(LoginDto loginDto);
}
