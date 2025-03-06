package com.google.linkedin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedin.entity.Address;
import com.google.linkedin.responsestrucutre.ResponseStructure;
import com.google.linkedin.service.AddressService;
import com.google.linkedin.util.AddressStatus;
import com.google.linkedin.util.AddressType;

@RestController
public class AddressController {

	@Autowired
	private AddressService ser;
	
	@PostMapping("/addersses")
	public ResponseStructure<Address> saveAddress(@RequestBody Address a){
		return ser.saveAddress(a);
	}
	@GetMapping("/addersses")
	public ResponseStructure<List<Address>> fecthAllAddress(){
		return ser.findAllAddress();
		
	}
	@GetMapping("/addersses/{id}")
	public ResponseStructure<Address> findAddressById(@PathVariable int id){
		return ser.findAddressById(id);
	}

	@PatchMapping("/addersses/type/{id}/{type}")
	public ResponseStructure<Address> changeAddressTypeById(@PathVariable int id, @PathVariable String type){
		return ser.changeAddressTypeById(id, AddressType.valueOf(type));
	}
	

	@PatchMapping("/addersses/status/{id}/{status}")
	public ResponseStructure<Address> changeAddressStatusById(@PathVariable int id, @PathVariable String status){
		return ser.changeAddressStatusById(id,AddressStatus.valueOf(status));
	}
	@PostMapping("/addersses/{eid}")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address,@PathVariable int eid){
		return ser.saveAddress(address, eid);
	}
	
	
	
}
