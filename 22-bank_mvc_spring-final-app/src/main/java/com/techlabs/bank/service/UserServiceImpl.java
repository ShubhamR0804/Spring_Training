package com.techlabs.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.bank.entity.Users;
import com.techlabs.bank.entity.dto.UserDto;
import com.techlabs.bank.exception.ResourceNotFoundException;
import com.techlabs.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto getUserById(int id) {
		Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return toDto(user);
	}

	private UserDto toDto(Users user) {
		UserDto dto = new UserDto();
		dto.setUserId(user.getUserId());
		dto.setUsername(user.getUsername());
		dto.setRole(user.getRole());
		return dto;
	}

}
