package com.google.linkedin.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.linkedin.exceptionclasses.ChangeAddressStatusById;
import com.google.linkedin.exceptionclasses.InvalidAddressIdException;
import com.google.linkedin.exceptionclasses.InvalidIdToChangeAddressType;
import com.google.linkedin.exceptionclasses.NoAddressFoundByIdException;
import com.google.linkedin.exceptionclasses.NoAddressFoundException;
import com.google.linkedin.responsestrucutre.ResponseStructure;

public class AddressExceptionHandler {

	
	@ExceptionHandler(NoAddressFoundException.class)
	public ResponseStructure<String> noAddressFoundException(NoAddressFoundException e){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(404);
		structure.setMessage("No Address Found");
		structure.setBody(e.getMessage());
		return structure;
	}
	
	@ExceptionHandler(NoAddressFoundByIdException.class)
	public ResponseStructure<String> noAddressFoundByIdException(NoAddressFoundByIdException e){
	ResponseStructure<String> structure= new ResponseStructure<>();
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setMessage("No Address Found By This ID");
	structure.setBody(e.getMessage());
	return structure;
	}
	@ExceptionHandler(InvalidIdToChangeAddressType.class)
	public ResponseStructure<String> invalidIdToChangeAddressType(InvalidIdToChangeAddressType e){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Invalid ID Unable to change the Address Type");
		structure.setBody(e.getMessage());
		return structure;
	}
	@ExceptionHandler(ChangeAddressStatusById.class)
	public ResponseStructure<String> changeAddressStatusById(ChangeAddressStatusById e){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Invalid ID Unable to change the Address STATUS");
		structure.setBody(e.getMessage());
		return structure;
	}
	@ExceptionHandler(InvalidAddressIdException.class)
	public ResponseStructure<String> invalidAddressIdException(InvalidAddressIdException e){
		ResponseStructure<String> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Invalid Addrees ID Not Found");
		structure.setBody(e.getMessage());
		return structure;
	}
}
