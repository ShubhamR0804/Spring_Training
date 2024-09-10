package com.techlabs.validationandexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techlabs.validationandexception.error.PaymentErrorResponse;

public class PaymentExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PaymentErrorResponse> handlePaymentNotFoundException(PaymentNotFoundException exception) {

		PaymentErrorResponse error = new PaymentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
