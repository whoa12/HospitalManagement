package com.projects.patients.PatientService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projects.patients.PatientService.entities.Patient;
import com.projects.patients.PatientService.repository.PatientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService implements iPatientService {
	private final PatientRepo repo;
	@Override
	public Patient createPatient(Patient patient) {
		String randomUUID = UUID.randomUUID().toString();
		patient.setId(randomUUID);
		return repo.save(patient); 
	}

	@Override
	public List<Patient> readAllPatients() {
		return repo.findAll(); }

	@Override
	public Patient updatePatient(String id, Patient updatedPatient) {
        return repo.findById(id).map(existingPatient -> {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setContactNo(updatedPatient.getContactNo());
            return repo.save(existingPatient);
        }).orElseThrow(() -> new IllegalArgumentException("Patient with ID " + id + " not found."));
    }


	@Override
	public void deletePatient(String id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		else {
			throw new IllegalArgumentException("User does not exist!");
		}
	}

	@Override
	public Patient getById(String id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("not found!"));
	}
}
	
	


