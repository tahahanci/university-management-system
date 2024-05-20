package com.hncdev.dormitoryservice.services.core.exception;

public class DormitoryNotFoundException extends RuntimeException {

    public DormitoryNotFoundException(String message) {
        super(message);
    }
}
