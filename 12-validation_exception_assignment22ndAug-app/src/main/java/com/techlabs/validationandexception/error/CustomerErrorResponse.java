package com.techlabs.validationandexception.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse {
	
	private int status;
    private String message;
    private long timestamp;

}
