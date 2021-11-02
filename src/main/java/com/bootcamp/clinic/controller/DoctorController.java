package com.bootcamp.clinic.controller;

import com.bootcamp.clinic.model.Doctor;
import com.bootcamp.clinic.request.DoctorCreationRQ;
import com.bootcamp.clinic.request.UpdateDoctorScheduleRQ;
import com.bootcamp.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //Get all doctors
    @GetMapping("/Doctors")
    public List<Doctor> getDoctors() {
        return doctorService.findAll();
    }

    //Get doctor by id
    @GetMapping("/Doctor/{id}")
    public Doctor getDoctorsById(@PathVariable Long id) {
        return doctorService.getDoctorsById(id);
    }

    //Create doctor
    @PostMapping(value = "/Doctors")
    public List<Doctor> createDoctors(@RequestBody @Valid List<DoctorCreationRQ> doctorCreationRQS) {
        return doctorService.createDoctors(doctorCreationRQS);
    }

    //Update doctor
    @PutMapping(value = "/Doctor-update/{id}")
    public Doctor updateDoctorSchedule(@PathVariable(value = "id") Long id, @RequestBody UpdateDoctorScheduleRQ updateDoctorScheduleRQ) {
        return doctorService.updateDoctor(id, updateDoctorScheduleRQ.getSchedule());
    }

    //Delete doctor
    @DeleteMapping(path = "/delete-doctor/{id}")
    public ResponseEntity deleteDoctor(@PathVariable(value = "id") Long doctorId) {
        doctorService.deleteById(doctorId);
        return ResponseEntity.created(URI.create("/doctor")).body("doctor removed");
    }
}