package com.example.rest.errors;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1L;
    private ErrorResponse error;

    public NotFoundException() {
    };

    public NotFoundException(String message, ErrorResponse error) {
        super(message);
        this.error = error;
    }

    public ErrorResponse getErrorInfo() {
        return error;
    }
}