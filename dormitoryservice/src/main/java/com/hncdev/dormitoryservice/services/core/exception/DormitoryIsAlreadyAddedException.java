package com.hncdev.dormitoryservice.services.core.exception;

public class DormitoryIsAlreadyAddedException extends RuntimeException {

    public DormitoryIsAlreadyAddedException(String message) {
        super(message);
    }
}
