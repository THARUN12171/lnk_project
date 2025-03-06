package com.google.linkedin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.linkedin.dao.EmployeeDao;
import com.google.linkedin.entity.Employee;
import com.google.linkedin.exceptionclasses.NoEmployeeFoundException;
import com.google.linkedin.responsestrucutre.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseStructure<Employee> saveEmployee(Employee e) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		try {
			e = dao.saveEmployee(e);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Employee Details saved successfully");
			structure.setBody(e);
		} catch (DataIntegrityViolationException d) {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMessage(" Employee Details NOT saved ");
			structure.setBody(null);
		} finally {
			return structure;
		}
	}

	public ResponseStructure<List<Employee>> findAllEmployee() {
		List<Employee> e = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (e.isEmpty()) {
			throw new NoEmployeeFoundException("Employee Not Found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Employee Found Successfully");
			structure.setBody(e);
		}
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllActiveEmployee() {
		List<Employee> emp = dao.findAllActiveEmployee();
		if (emp.isEmpty()) {
//        	throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Found Successfully");
		structure.setBody(emp);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllInActiveEmployee() {
		List<Employee> emp = dao.findAllInActiveEmployee();
		if (emp.isEmpty()) {
//        	throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("All Employees Found Successfully");
		structure.setBody(emp);
		return structure;
	}

	public ResponseStructure<Employee> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		if (optional.isEmpty()) {
//		throw new InvalidEmployeeIdException();
		}
		Employee employee = optional.get();
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Found Successfully");
		structure.setBody(employee);
		return structure;
	}

	public ResponseStructure<Employee> loginEmployee(String email, String password) {
	Optional<Employee>optional=	dao.findByEmailAndPassword(email,password);
	ResponseStructure<Employee> structure= new ResponseStructure<>();
	if(optional.isEmpty()) {
//		throw new InvalidLoginIdException();
	}else {
		structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Login Successful");
        structure.setBody(optional.get());
	}
	return structure;
	}
}
