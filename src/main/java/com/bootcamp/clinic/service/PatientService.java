package com.bootcamp.clinic.service;

import com.bootcamp.clinic.exception.PatientNotFound;
import com.bootcamp.clinic.model.Patient;
import com.bootcamp.clinic.repository.PatientRepository;
import com.bootcamp.clinic.request.PatientCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //Find all patients
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    //Find by Id
    public Patient getPatientsById(Long id) {
        return patientRepository.findById(id).orElseThrow(PatientNotFound::new);
    }

    //Create new patient (List)
    public List<Patient> createPatients(List<PatientCreationRQ> patientCreationRQList) {
        List<Patient> newPatientList = new ArrayList<>();
        Patient newPatient;
        for (PatientCreationRQ patientCreationRQ : patientCreationRQList) {
            newPatient = Patient.builder()
                    .name(patientCreationRQ.getName())
                    .diagnosis(patientCreationRQ.getDiagnosis())
                    .build();
            patientRepository.save(newPatient);
            newPatientList.add(newPatient);
        }
        return newPatientList;
    }

    //Update patient's by diagnosis
    public Patient updatePatient(Long id, String diagnosis) {
        Patient patientToUpdate = this.getPatientsById(id);
        patientToUpdate.setDiagnosis(diagnosis);
        patientRepository.save(patientToUpdate);
        return patientToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getPatientsById(id);
        patientRepository.deleteById(id);

    }
}