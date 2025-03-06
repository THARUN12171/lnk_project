package com.google.linkedin.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.linkedin.exceptionclasses.InvalidEmployeeIdException;
import com.google.linkedin.exceptionclasses.NoEmployeeFoundException;
import com.google.linkedin.responsestrucutre.ResponseStructure;

public class EmployeeExceptionHandler {

	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseStructure<String> noEmployeeFoundException(NoEmployeeFoundException e){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("No Employee Found");
		structure.setBody(e.getMessage());
		return structure;
	}
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseStructure<String> invalidEmployeeIdException(InvalidEmployeeIdException e){
		ResponseStructure<String> structure=  new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("No Employee Found By This ID");
		structure.setBody(e.getMessage());
		return structure;
	}
}
