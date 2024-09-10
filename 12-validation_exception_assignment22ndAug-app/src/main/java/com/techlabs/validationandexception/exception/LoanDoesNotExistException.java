package com.techlabs.validationandexception.exception;

public class LoanDoesNotExistException extends RuntimeException {
    public String LoanDoesNotExistException(String message) {
        return "Loan does not exist";
    }

}
