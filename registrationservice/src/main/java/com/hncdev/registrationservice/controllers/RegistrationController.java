package com.hncdev.registrationservice.controllers;

import com.hncdev.registrationservice.service.abstracts.RegistrationService;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import com.hncdev.registrationservice.service.dtos.responses.RegisterStudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public RegisterStudentResponse registerStudent(@RequestBody RegisterStudentRequest request) {
        return registrationService.registerStudent(request);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable String studentId) {
        registrationService.deleteStudent(studentId);
    }
}
