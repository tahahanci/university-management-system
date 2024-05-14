package com.hncdev.authservice.services.concretes;

import com.hncdev.authservice.services.abstracts.AuthService;
import com.hncdev.authservice.services.abstracts.UserService;
import com.hncdev.authservice.services.dtos.requests.LoginStudentRequest;
import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public void register(RegisterStudentRequest registerStudentRequest) {
        userService.add(registerStudentRequest);
    }

    @Override
    public void login(LoginStudentRequest loginStudentRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginStudentRequest.getUsername(),
                loginStudentRequest.getPassword()
        ));
    }
}
