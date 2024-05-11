package com.hncdev.studentservice.services.core.handler;

import com.hncdev.studentservice.services.core.details.BusinessProblemDetails;
import com.hncdev.studentservice.services.core.exception.CourseNotFoundException;
import com.hncdev.studentservice.services.core.exception.DepartmentNotFoundException;
import com.hncdev.studentservice.services.core.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BusinessProblemDetails handleCourseNotFoundException(CourseNotFoundException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BusinessProblemDetails handleDepartmentNotFoundException(DepartmentNotFoundException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BusinessProblemDetails handleStudentNotFoundException(StudentNotFoundException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }
}
