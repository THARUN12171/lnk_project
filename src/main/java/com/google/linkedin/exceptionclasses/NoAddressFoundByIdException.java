package com.google.linkedin.exceptionclasses;

public class NoAddressFoundByIdException extends RuntimeException {

	
	private String message;
	
	public NoAddressFoundByIdException(String message) {
		 this.message=message;
	}

	public NoAddressFoundByIdException() {
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
