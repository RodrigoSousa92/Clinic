package com.bootcamp.clinic.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomCreationRQ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
}
