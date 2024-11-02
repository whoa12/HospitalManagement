package com.projects.patients.PatientService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.patients.PatientService.entities.Patient;
import com.projects.patients.PatientService.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
	private final PatientService service;
	
	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> getPatientsInfo(@PathVariable String patientId){
		return new ResponseEntity<>(service.getById(patientId), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
	    return new ResponseEntity<>(service.createPatient(patient), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients(){
		return new ResponseEntity<>(service.readAllPatients(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{paitentId}")
	public ResponseEntity<Void> deletePatientById(@PathVariable String patientId){
		service.deletePatient(patientId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update/{patientId}")
	public void updatePatientDetails(@PathVariable String patientId, @RequestBody Patient patient) {
		service.updatePatient(patientId, patient);
		
	}
	
	

}
