package com.hncdev.registrationservice.controllers;

import com.hncdev.registrationservice.service.abstracts.RegistrationService;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public void registerStudent(@RequestBody RegisterStudentRequest request) {
        registrationService.registerStudent(request);
    }
}
