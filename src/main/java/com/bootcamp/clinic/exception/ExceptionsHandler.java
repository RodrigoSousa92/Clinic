package com.bootcamp.clinic.exception;

import com.bootcamp.clinic.controller.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({PatientNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpResponse handleGenericException(PatientNotFound exception) {
        return new HttpResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}