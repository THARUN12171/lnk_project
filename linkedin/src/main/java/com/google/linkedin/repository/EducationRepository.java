package com.google.linkedin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.linkedin.entity.Address;
import com.google.linkedin.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Integer>{

	Education save(Address address);

}
