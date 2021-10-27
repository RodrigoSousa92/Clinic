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

    @ManyToMany(mappedBy = "patientDoctors")
    private Set<Doctor> doctor = new HashSet<>();

}
