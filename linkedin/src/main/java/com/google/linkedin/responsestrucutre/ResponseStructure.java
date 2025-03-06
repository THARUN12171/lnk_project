package com.google.linkedin.responsestrucutre;

import java.util.List;

import com.google.linkedin.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {


	 private int status;
	 private String message;
	 private T body;
	
}
