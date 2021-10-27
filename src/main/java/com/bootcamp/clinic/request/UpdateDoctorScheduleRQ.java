package com.bootcamp.clinic.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDoctorScheduleRQ {

    private String schedule;
}
