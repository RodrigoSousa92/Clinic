package com.bootcamp.clinic.exception;

public class DoctorNotFound extends RuntimeException {
    public DoctorNotFound() {
        super("Doctor not found.");
    }

    public DoctorNotFound(String message) {
        super(message);
    }
}
