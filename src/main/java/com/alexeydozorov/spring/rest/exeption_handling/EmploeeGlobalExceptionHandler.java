package com.alexeydozorov.spring.rest.exeption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmploeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmploeeIncorectData> handlerException(NoSuchEmploeeException exception) {
        EmploeeIncorectData data = new EmploeeIncorectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmploeeIncorectData> handlerException(Exception exception) {
        EmploeeIncorectData data = new EmploeeIncorectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
