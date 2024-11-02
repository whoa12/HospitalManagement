package com.projects.patients.PatientService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private String id;
    private String name;
    private Long contactNo;
    private String password;
    
    @Transient
    private List<Doctor> getAllDoctorsList = new ArrayList<Doctor>();

    
}
