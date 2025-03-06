package com.google.linkedin.exceptionclasses;

public class InvalidIdToChangeAddressType extends RuntimeException {

	private String message;
	
	public InvalidIdToChangeAddressType(String message) {
		this.message=message;
	}

	public InvalidIdToChangeAddressType() {
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
