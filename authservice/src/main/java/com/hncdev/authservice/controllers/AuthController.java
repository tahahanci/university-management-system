package com.hncdev.authservice.controllers;

import com.hncdev.authservice.services.abstracts.AuthService;
import com.hncdev.authservice.services.dtos.requests.LoginStudentRequest;
import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterStudentRequest registerRequest) {
        authService.register(registerRequest);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginStudentRequest loginRequest) {
        authService.login(loginRequest);
    }

}
