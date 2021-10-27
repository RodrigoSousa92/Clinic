package com.bootcamp.clinic.exception;

public class PatientNotFound extends RuntimeException {
    public PatientNotFound() {
        super("Patient not found.");
    }

    public PatientNotFound(String message) {
        super(message);
    }
}
