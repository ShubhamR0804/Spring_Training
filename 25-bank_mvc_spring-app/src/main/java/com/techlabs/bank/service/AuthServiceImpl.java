package com.techlabs.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlabs.bank.dto.LoginDto;
import com.techlabs.bank.dto.RegisterationDto;
import com.techlabs.bank.entity.Roles;
import com.techlabs.bank.entity.Users;
import com.techlabs.bank.exception.UserApiException;
import com.techlabs.bank.repository.RoleRepository;
import com.techlabs.bank.repository.UserRepository;
import com.techlabs.bank.security.JwtTokenProvider;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider tokenProvider;

	@Override
	public Users register(RegisterationDto registerDto) {
		// TODO Auto-generated method stub
		if (userRepo.existsByUsername(registerDto.getUsername()))
			throw new UserApiException(HttpStatus.BAD_REQUEST, "User already exists");

		Users user = new Users();
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		List<Roles> roles = new ArrayList<Roles>();

		Roles userRole = roleRepo.findByRoleName(registerDto.getRole()).get();
		roles.add(userRole);
		user.setRoles(roles);

		return userRepo.save(user);
	}

	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		try {

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.generateToken(authentication);

			return token;
			
		} catch (BadCredentialsException e) {

			throw new UserApiException(HttpStatus.NOT_FOUND, "Username or Password is incorrect");
		}
	}

}
