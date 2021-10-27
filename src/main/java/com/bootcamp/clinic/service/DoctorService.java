package com.bootcamp.clinic.service;

import com.bootcamp.clinic.exception.DoctorNotFound;
import com.bootcamp.clinic.model.Doctor;
import com.bootcamp.clinic.repository.DoctorRepository;
import com.bootcamp.clinic.request.DoctorCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    //Find all doctors
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    //Find by Id
    public Doctor getDoctorsById(Long id) {
        return doctorRepository.findById(id).orElseThrow(DoctorNotFound::new);
    }


    //Create new doctors (List)
    public List<Doctor> createDoctors(List<DoctorCreationRQ> doctorCreationRQList) {
        List<Doctor> newDoctorList = new ArrayList<>();
        Doctor newDoctor;
        for (DoctorCreationRQ doctorCreationRQ : doctorCreationRQList) {
            newDoctor = Doctor.builder()
                    .name(doctorCreationRQ.getName())
                    .schedule(doctorCreationRQ.getSchedule())
                    .build();
            doctorRepository.save(newDoctor);
            newDoctorList.add(newDoctor);
        }
        return newDoctorList;
    }

    //Update doctor's by schedule
    public Doctor updateDoctor(Long id, String schedule) {
        Doctor doctorToUpdate = this.getDoctorsById(id);
        doctorToUpdate.setSchedule(schedule);
        doctorRepository.save(doctorToUpdate);
        return doctorToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getDoctorsById(id);
        doctorRepository.deleteById(id);
    }
}