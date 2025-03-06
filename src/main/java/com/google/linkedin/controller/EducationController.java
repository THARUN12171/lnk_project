package com.google.linkedin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Education;
import com.google.linkedin.entity.Employee;
import com.google.linkedin.responsestrucutre.ResponseStructure;
import com.google.linkedin.service.EducationService;

@RestController
public class EducationController {
  
	@Autowired
	private EducationService ser;
	
	@PostMapping("/educations/{eid}")
	public ResponseStructure<Education> saveEducation(@RequestBody Education education, @PathVariable int eid){
		return ser.saveEducation(education, eid);
	}
	@GetMapping("/educations/employee/{eid}")
	public ResponseStructure<List<Education>> findAllEducationsByEmployeeId(@PathVariable int eid){ 
		return ser.findAllEducationsByEmployeeId(eid);
	}
	@PatchMapping("/educations/status/inactive/{id}")
	public ResponseStructure<Education> setStatusToInactive(@PathVariable int id){
		return ser.setStatusToInactive(id);
	}
}
