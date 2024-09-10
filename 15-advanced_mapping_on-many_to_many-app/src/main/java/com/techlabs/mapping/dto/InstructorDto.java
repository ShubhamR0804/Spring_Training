package com.techlabs.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class InstructorDto {
	
	private int instructorId;
	
	private String name;
	
	private String email;
	
	private String qualification;
	

}
