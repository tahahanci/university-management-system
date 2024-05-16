package com.hncdev.authservice.services.concretes;

import com.hncdev.authservice.core.jwt.JwtService;
import com.hncdev.authservice.services.abstracts.AuthService;
import com.hncdev.authservice.services.abstracts.UserService;
import com.hncdev.authservice.services.dtos.requests.LoginStudentRequest;
import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public void register(RegisterStudentRequest registerStudentRequest) {
        userService.add(registerStudentRequest);
    }

    @Override
    public String login(LoginStudentRequest loginStudentRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginStudentRequest.getUsername(),
                loginStudentRequest.getPassword()
        ));
        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Invalid username or password");
        }
        UserDetails user = userService.loadUserByUsername(loginStudentRequest.getUsername());
        return jwtService.generateToken(user.getUsername());
    }
}
