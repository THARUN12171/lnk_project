package com.google.linkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.google.linkedin.entity.Employee;
import com.google.linkedin.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repo;

	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}

	public List<Employee> findAllEmployee() {
		return repo.findAll();
	}

	public List<Employee> findAllActiveEmployee() {
		return repo.findAllActiveEmployee();
	}

	public List<Employee> findAllInActiveEmployee() {
		return repo.findAllInActiveEmployee();
	}


	public Optional<Employee> findEmployeeById(int id) {
		return repo.findById(id);
	}

	public Optional<Employee> findByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

	
}
