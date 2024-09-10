package com.techlabs.validationandexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techlabs.validationandexception.error.LoanErrorResponse;

@ControllerAdvice
public class LoanExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<LoanErrorResponse> handleLoanDoesNotExistException(LoanDoesNotExistException exception) {

		LoanErrorResponse error = new LoanErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<LoanErrorResponse> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		LoanErrorResponse error = new LoanErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation error: " + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
