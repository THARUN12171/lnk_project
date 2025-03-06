package com.google.linkedin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedin.entity.Education;
import com.google.linkedin.repository.EducationRepository;

@Repository
public class EducationDao {

	 @Autowired
	 private EducationRepository repo;

	public Education saveEducation(Education e) {
		return repo.save(e);
	}

	public List<Education> findAllEducations() {
		return repo.findAll();
	}

	public Optional<Education> findEducationById(int id) {
		return repo.findById(id);
	}

}
