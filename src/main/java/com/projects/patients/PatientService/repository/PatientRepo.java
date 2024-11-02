package com.projects.patients.PatientService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.patients.PatientService.entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String>{
	Optional<Patient> findById(String id);
	

}
