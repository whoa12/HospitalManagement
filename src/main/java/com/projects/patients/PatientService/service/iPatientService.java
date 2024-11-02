package com.projects.patients.PatientService.service;

import java.util.List;
import com.projects.patients.PatientService.entities.Patient;

public interface iPatientService {
	public Patient createPatient(Patient patient);
	public List<Patient> readAllPatients();
	public Patient updatePatient(String id, Patient updatedPatient);
	public void deletePatient(String id);
	public Patient getById(String id);

}
