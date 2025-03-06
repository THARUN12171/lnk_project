package com.google.linkedin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.linkedin.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployee();

	@Query("select e from Employee e where e.status='IN_ACTIVE'")
	List<Employee> findAllInActiveEmployee();


	Optional<Employee> findByEmailAndPassword(String email, String password);
}
