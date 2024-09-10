package com.techlabs.validationandexception.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LoanErrorResponse {
	private int status;
    private String message;
    private long timestamp;

}
