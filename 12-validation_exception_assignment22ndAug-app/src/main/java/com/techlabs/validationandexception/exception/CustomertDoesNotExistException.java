package com.techlabs.validationandexception.exception;

public class CustomertDoesNotExistException extends RuntimeException {
	public String getMessage() {
		return "Customer does not exist";
		}

}
