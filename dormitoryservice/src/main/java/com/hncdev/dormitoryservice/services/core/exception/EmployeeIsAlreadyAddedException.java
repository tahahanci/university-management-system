package com.hncdev.dormitoryservice.services.core.exception;

public class EmployeeIsAlreadyAddedException extends RuntimeException {

    public EmployeeIsAlreadyAddedException(String message) {
        super(message);
    }

}
