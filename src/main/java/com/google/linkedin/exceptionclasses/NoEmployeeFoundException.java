package com.google.linkedin.exceptionclasses;

public class NoEmployeeFoundException extends RuntimeException {

	 private String message;
	 
	 public NoEmployeeFoundException(String message) {
		 this.message=message;
	 }
	 
	 
	 public NoEmployeeFoundException() {
	}


	@Override
	public String getMessage() {
		return this.message;
	}
}
