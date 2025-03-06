package com.google.linkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Employee;
import com.google.linkedin.repository.AddressRespository;

@Repository
public class AddressDao {

	
	@Autowired
	private AddressRespository repo;

	public Address saveAddress(Address a) throws DataIntegrityViolationException{
		return repo.save(a);
	}
	public List<Address> findAllAddress() {
		return repo.findAll();
	}

	public Optional<Address> findAddressById(int id) {
		return repo.findById(id);
	}

	public Optional<Address> changeAddressTypeById(int id) {
		return repo.findById(id);
	}

	public Optional<Address> changeAddressStatusById(int id) {
		return repo.findById(id);
	}
	
	public Address saveEmployee(Address address) {
		return repo.save(address);
	}
	
	
	
}
