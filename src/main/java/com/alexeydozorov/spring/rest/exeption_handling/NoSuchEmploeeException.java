package com.alexeydozorov.spring.rest.exeption_handling;

public class NoSuchEmploeeException extends RuntimeException{
    public NoSuchEmploeeException(String message) {
        super(message);
    }
}
