package com.google.linkedin.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.google.linkedin.util.EmployeeStatus;
import com.google.linkedin.util.Experience;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	@CreationTimestamp
	private LocalDateTime dateOfJoin;
	private String email;
	private double salary;
	private long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Experience experience = Experience.FRESHER;// enum-> EXPERIENCED || FRESHER
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status = EmployeeStatus.ACTIVE;// enum -> ACTIVE || IN_ACTIVE|| BLOCKED|| 

}
// POST-->   /employees       json Obj employee{data}    --> save an employee
//GEt-->    /employees                     -->fetch all employees
//GET-->    /employees/{eid}        -->fetch an employee by an id
//POST-->/employees/login     json Obj login{} -->login verification by email and password









