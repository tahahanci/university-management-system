package com.hncdev.dormitoryservice.services.core.handler;

import com.hncdev.dormitoryservice.services.core.details.BusinessProblemDetails;
import com.hncdev.dormitoryservice.services.core.exception.DormitoryIsAlreadyAddedException;
import com.hncdev.dormitoryservice.services.core.exception.DormitoryNotFoundException;
import com.hncdev.dormitoryservice.services.core.exception.EmployeeIsAlreadyAddedException;
import com.hncdev.dormitoryservice.services.core.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DormitoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BusinessProblemDetails handleDormitoryNotFoundException(DormitoryNotFoundException e) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(e.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(EmployeeIsAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleEmployeeIsAlreadyAddedException(EmployeeIsAlreadyAddedException e) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(e.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BusinessProblemDetails handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(e.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(DormitoryIsAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleDormitoryIsAlreadyAddedException(DormitoryIsAlreadyAddedException e) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(e.getMessage());
        return problemDetails;
    }

}
