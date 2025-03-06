package com.google.linkedin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedin.entity.Employee;
import com.google.linkedin.responsestrucutre.ResponseStructure;
import com.google.linkedin.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService ser;
	
	@PostMapping("/employees")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee e){
		return ser.saveEmployee(e);
	}
	@GetMapping("/employees")
	public ResponseStructure<List<Employee>> fecthAllEmployee(){
		return ser.findAllEmployee();
	}
	@GetMapping("/status/active")
	public ResponseStructure<List<Employee>> findAllActiveEmployee(){
		return ser.findAllActiveEmployee();
	}
	@GetMapping("/status/in_active")
	public ResponseStructure<List<Employee>> findAllInActiveEmployee(){
		return ser.findAllInActiveEmployee();
	}
	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id){
		return ser.findEmployeeById(id);
	}
	@PostMapping("/employees/login")
	public ResponseStructure<Employee> loginEmployee(@RequestParam String email, @RequestParam String password){
		return ser.loginEmployee(email,password);
	}
	
}
