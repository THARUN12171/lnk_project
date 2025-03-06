package com.google.linkedin.exceptionclasses;

public class InvalidEmployeeIdException extends RuntimeException {
  
	private String message;
	
	public InvalidEmployeeIdException(String message) {
		this.message=message;
	}

	public InvalidEmployeeIdException() {
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
