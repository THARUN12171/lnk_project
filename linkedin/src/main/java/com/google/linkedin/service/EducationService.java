package com.google.linkedin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.linkedin.dao.AddressDao;
import com.google.linkedin.dao.EducationDao;
import com.google.linkedin.dao.EmployeeDao;
import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Education;
import com.google.linkedin.entity.Employee;
import com.google.linkedin.exceptionclasses.InvalidEmployeeIdException;
import com.google.linkedin.responsestrucutre.ResponseStructure;
import com.google.linkedin.util.EducationStatus;

@Service
public class EducationService {

	@Autowired
	private EducationDao dao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private AddressDao addressDao;

	public ResponseStructure<Education> saveEducation(Education education, int eid) {
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			throw new InvalidEmployeeIdException("Invalid Employeee Id Not Found");
		} else {
			Employee employee = optional.get();
			education.setEmployee(employee);
			education = dao.saveEducation(education);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Education save success");
			structure.setBody(education);
		}
		return structure;

	}
//
//	public ResponseStructure<Employee> saveAddress(Address address, int eid) {
//		Optional<Address> optional= addressDao.findAddressById(eid);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		if(optional.isEmpty()) {
//			//throw new InvalidAddressIdException();
//		}else {
//			 Address existingAddress = optional.get();
//			 Employee employee = existingAddress.getEmployee();
//			address.setEmployee(employee);
//			address=addressDao.saveAddress(address);
//			employee.getAddresses().add(address);
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setMessage("Education save success");
//			structure.setBody(employee);
//		}
//		return structure;
//	}

	public ResponseStructure<List<Education>> findAllEducationsByEmployeeId(int eid) {
		List<Education> el = dao.findAllEducations();
		if (el.isEmpty()) {
//			throw new NoEducationFoundException();
		}
		ArrayList<Education> fel = new ArrayList<>();
		for (Education edu : el) {
			Employee emp = edu.getEmployee();
			if (emp.getId() == eid) {
				fel.add(edu);
			}
		}
		if (fel.isEmpty()) {
			// throw new NoEducationFoundException();
		}
		ResponseStructure<List<Education>> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("All educations Found Successfully from Employee Id:"+eid);
		structure.setBody(fel);
		return structure;
	}

	public ResponseStructure<Education> setStatusToInactive(int id) {
		Optional<Education> optional=dao.findEducationById(id);
		if(optional.isEmpty()) {
//			throw new InvalideducationIdException();
		}
		Education education = optional.get();
		education.setStatus(EducationStatus.IN_ACTIVE);
		education=dao.saveEducation(education);
		ResponseStructure<Education> structure= new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education Status Updated to IN_ACTIVE successfully..");
		structure.setBody(education);
		return structure;
	}
}
