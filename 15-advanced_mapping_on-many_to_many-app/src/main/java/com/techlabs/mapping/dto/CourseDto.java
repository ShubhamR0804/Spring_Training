package com.techlabs.mapping.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CourseDto {
	
	private int courseID;
	
	private String name;
	
	private int duration;
	
	private BigDecimal fees;
	

}
