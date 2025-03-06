package com.google.linkedin.exceptionclasses;

public class ChangeAddressStatusById extends RuntimeException {

	private String message;
	
	public ChangeAddressStatusById(String message) {
		this.message=message;
	}
	
	 
	public ChangeAddressStatusById() {
	}


	@Override
	public String getMessage() {
		return this.message;
	}
	
}
