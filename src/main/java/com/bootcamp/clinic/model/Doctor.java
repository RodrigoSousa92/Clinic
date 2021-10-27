package com.bootcamp.clinic.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String schedule;

    @ManyToMany
    @JoinTable(
            name = "patient_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patientDoctors = new HashSet<>();
}
