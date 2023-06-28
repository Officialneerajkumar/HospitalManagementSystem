package com.example.HospitalManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    @Length(min = 3)
    private String doctorName;
    @Enumerated(EnumType.ORDINAL)
    private DoctorCity doctorCity;
    @Email
    private String doctorEmail;
    @Length(min = 10)
    private String doctorContact;
    @Enumerated(EnumType.ORDINAL)
    private Specialization doctorSpecialization;

}
