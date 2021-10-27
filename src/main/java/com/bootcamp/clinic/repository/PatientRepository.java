package com.bootcamp.clinic.repository;

import com.bootcamp.clinic.model.Patient;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
