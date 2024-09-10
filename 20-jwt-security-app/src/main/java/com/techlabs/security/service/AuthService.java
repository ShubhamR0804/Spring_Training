package com.techlabs.security.service;

import com.techlabs.security.dto.LoginDto;
import com.techlabs.security.dto.RegisterationDto;
import com.techlabs.security.entity.User;

public interface AuthService {
	User register(RegisterationDto registeration);

	String login(LoginDto loginDto);
}
