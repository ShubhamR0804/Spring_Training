package com.techlabs.jpacrudoperation.exception;

public class StudentDoesNotExistException extends RuntimeException {
	
	public String getMessage()
	{
		return "Student Does Not Exist";
	}
}
