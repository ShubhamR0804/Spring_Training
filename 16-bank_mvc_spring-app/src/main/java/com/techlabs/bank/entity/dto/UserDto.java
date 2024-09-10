package com.techlabs.bank.entity.dto;

import com.techlabs.bank.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
	private int userId;
    private String username;
    private Role role;
}
