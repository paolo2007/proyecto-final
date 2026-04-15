package com.proyecto.biblioteca.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
