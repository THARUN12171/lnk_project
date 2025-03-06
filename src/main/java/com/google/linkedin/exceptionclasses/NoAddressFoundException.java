package com.google.linkedin.exceptionclasses;

public class NoAddressFoundException extends RuntimeException {

	
	private String message;
	
	public NoAddressFoundException(String message) {
		this.message=message;
	}
	
	
	public NoAddressFoundException() {
	}


	@Override
	public String getMessage() {
		return this.message;
	}
}
