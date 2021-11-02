package com.bootcamp.clinic.controller;

import com.bootcamp.clinic.model.Patient;
import com.bootcamp.clinic.request.PatientCreationRQ;
import com.bootcamp.clinic.request.UpdatePatientDiagnosisRQ;
import com.bootcamp.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PatientController {
    @Autowired
    PatientService patientService;

    //Get all patients
    @GetMapping("/Patients")
    public List<Patient> getPatients() {
        return patientService.findAll();
    }

    //Get patients by id
    @GetMapping("/Patients/{id}")
    public Patient getPatientsById(@PathVariable Long id) {
        return patientService.getPatientsById(id);
    }

    //Create patient
    @PostMapping(value = "/Patients")
    public List<Patient> createPatients(@RequestBody @Valid List<PatientCreationRQ> createPatientRQ) {
        return patientService.createPatients(createPatientRQ);
    }

    //Update patient
    @PutMapping(value = "/Patient-update/{id}")
    public Patient updatePatientDiagnosis(@PathVariable(value = "id") Long id, @RequestBody UpdatePatientDiagnosisRQ updatePatientDiagnosisRQ) {
        return patientService.updatePatient(id, updatePatientDiagnosisRQ.getDiagnosis());
    }

    //Delete patient
    @DeleteMapping(value = "/Patient-delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        patientService.deleteById(id);
    }
}
