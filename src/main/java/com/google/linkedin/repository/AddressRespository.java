package com.google.linkedin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Employee;

public interface AddressRespository extends JpaRepository<Address, Integer>{

	Address save(Employee employee);

	


}
