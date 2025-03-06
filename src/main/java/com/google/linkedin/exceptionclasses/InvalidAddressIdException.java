package com.google.linkedin.exceptionclasses;

public class InvalidAddressIdException extends RuntimeException {

	 private String message;
	 
	 public InvalidAddressIdException(String message) {
		 this.message=message;
	 }

	public InvalidAddressIdException() {
	}
	 
	 @Override
	public String getMessage() {
		return this.message;
	}
}
