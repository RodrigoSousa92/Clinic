package com.bootcamp.clinic.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorCreationRQ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String schedule;
}
