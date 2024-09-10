package com.techlabs.validationandexception.exception;

public class PaymentNotFoundException extends RuntimeException {
	public String PaymentNotFoundException(String message) {
		return "Payment not found";
	}

}
