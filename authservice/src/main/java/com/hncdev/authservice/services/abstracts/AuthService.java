package com.hncdev.authservice.services.abstracts;

import com.hncdev.authservice.services.dtos.requests.LoginStudentRequest;
import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;

public interface AuthService {

    void register(RegisterStudentRequest registerStudentRequest);

    void login(LoginStudentRequest loginStudentRequest);
}
