package com.example.HospitalManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Length(min = 3)
    private String patientName;
    @Length(max = 20)
    private String patientCity;
    @Email
    private String patientEmail;
    private String patientPassword;
    @Length(min = 10)
    private String patientContact;
    @Enumerated(EnumType.STRING)
    private Symptoms symptoms;

    public Patient(String patientName, String patientCity, String patientEmail, String patientContact, Symptoms symptoms) {
        this.patientName = patientName;
        this.patientCity = patientCity;
        this.patientEmail = patientEmail;
        this.patientContact = patientContact;
        this.symptoms = symptoms;
    }
}
