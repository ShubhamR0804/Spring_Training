package com.techlabs.validationandexception.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PageResponseDto<T> {
	private long totalElements;
    private long totalPages;
    private int size;
    private List<T> content;
    private boolean lastPage;

}
