package com.techlabs.validationandexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techlabs.validationandexception.error.CustomerErrorResponse;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleCustomerDoesNotExistException(
			CustomertDoesNotExistException exception) {

		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler public ResponseEntity<CustomerErrorResponse>
	 * handleMethodArgumentNotValidException( MethodArgumentNotValidException
	 * exception) {
	 * 
	 * String errorMessage =
	 * exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	 * CustomerErrorResponse error = new
	 * CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage,
	 * System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */

}
