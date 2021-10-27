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
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "id_room")
    Room room;

    // I think the many to many is the thing i feel most difficulty, it created the table (in DB Browser) but im not sure if it is working properly,
    // in swagger when i create a new patient or a new doctor it appears the value as null,
    // in  case of the patient(doctor associated as null) and the same with the doctor creation.
    @ManyToMany(mappedBy = "patientDoctors")
    private Set<Doctor> doctor = new HashSet<>();

}
