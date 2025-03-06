package com.google.linkedin.entity;

import com.google.linkedin.util.AddressStatus;
import com.google.linkedin.util.AddressType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String doorNo;
	private String addressLine1;
	private String addressLine2;// optional
	private String landmark;
	private String city;
	private String state;
	private String country;
	private int pincode;

	@Enumerated(EnumType.STRING)
	private AddressStatus status = AddressStatus.ACTIVE;
	@Enumerated(EnumType.STRING)
	private AddressType type =AddressType.PERSENT ;// enum-> PERMANENT|| PRESENT|| WORK || DELETED
	@ManyToOne
	private Employee employee;
}

// POST-->/addresses/{eid}  address json OBJ{}  --> save address for a employee

// GET--> /addresses/                            --> fetch all address of an employee

// GET--> /addresses/{aid}                       --> fetch a address by it's id

// PATCH--> /addresses/type/{aid}/{type}         -->change the address type by id

// PATCH-->//addresses/status/{aid}/{status}    -->change the satus of an address by it's id

