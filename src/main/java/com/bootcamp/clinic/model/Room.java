package com.bootcamp.clinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;

    @OneToMany(mappedBy = "room")
    private List<Patient> patient;
}
