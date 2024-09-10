package com.techlabs.assignmentmapping.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PageDto<T> {
	
	private long totalElements;
	private int totalPages;
	private int size;
	private List<T> content;
	private boolean isLastPage;

}
