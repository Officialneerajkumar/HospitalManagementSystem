package com.example.HospitalManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Min(value = 3)
    private String patientName;
    @Max(value = 20)
    private String patientCity;
    @Email
    private String patientEmail;
    @Min(value = 10)
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX first two digit will be country code other will be 10 digit phone number")
    private String patientContact;
    private String symtoms;

}
