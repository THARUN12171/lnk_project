package com.google.linkedin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.linkedin.dao.AddressDao;
import com.google.linkedin.dao.EmployeeDao;
import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Employee;
import com.google.linkedin.exceptionclasses.ChangeAddressStatusById;
import com.google.linkedin.exceptionclasses.InvalidAddressIdException;
import com.google.linkedin.exceptionclasses.InvalidIdToChangeAddressType;
import com.google.linkedin.exceptionclasses.NoAddressFoundByIdException;
import com.google.linkedin.exceptionclasses.NoAddressFoundException;
import com.google.linkedin.responsestrucutre.ResponseStructure;
import com.google.linkedin.util.AddressStatus;
import com.google.linkedin.util.AddressType;

@Service
public class AddressService {

	
	@Autowired
	private AddressDao dao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public ResponseStructure<Address> saveAddress(Address a) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		try {
			a = dao.saveAddress(a);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address saved successfully");
			structure.setBody(a);
		} catch (DataIntegrityViolationException e) {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMessage("Address NOT saved ");
			structure.setBody(null);
		} finally {
			return structure;
		}
	}
	

	public ResponseStructure<List<Address>> findAllAddress() {
		List<Address> al = dao.findAllAddress();
		ResponseStructure<List<Address>> structure = new ResponseStructure<>();
		if (al.isEmpty()) {
			throw new NoAddressFoundException("Address Not Found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address Found Successfully");
			structure.setBody(al);
		}
		return structure;
	}
	
	public ResponseStructure<Address> findAddressById(int id) {
		Optional<Address> al = dao.findAddressById(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (al.isEmpty()) {
			throw new NoAddressFoundByIdException("Address Not Found By This ID");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address Found with this Id:" + id);
			structure.setBody(al.get());
		}
		return structure;
	}
	
	

	public ResponseStructure<Address> changeAddressTypeById(int id, AddressType type) {
		Optional<Address> al = dao.changeAddressTypeById(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (al.isEmpty()) {
			throw new InvalidIdToChangeAddressType("Invalid Id not able to change the TYPE");
		} else {
			Address address = al.get();
			address.setType(type);
			dao.saveAddress(address);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address Type Changed Successfully");
			structure.setBody(al.get());
		}
		return structure;
	}

	public ResponseStructure<Address> changeAddressStatusById(int id, AddressStatus status) {
		Optional<Address> al = dao.changeAddressStatusById(id);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (al.isEmpty()) {
			throw new ChangeAddressStatusById("Unable to change the STATUS");

		} else {
			Address ad = al.get();
			ad.setStatus(status);
			dao.saveAddress(ad);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address Status Changed Successfully");
			structure.setBody(al.get());
		}
		return structure;
	}


	public ResponseStructure<Address> saveAddress(Address address, int eid) {
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		ResponseStructure<Address> structure= new ResponseStructure<>();
		if(optional.isEmpty()) {
			 throw new InvalidAddressIdException("Invalid Address Id");
		}else {
			Employee employee = optional.get();
			address.setEmployee(employee);
			address=dao.saveAddress(address);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Address Saved");
			structure.setBody(address);
		}
		return structure;
	
	}
	
}


