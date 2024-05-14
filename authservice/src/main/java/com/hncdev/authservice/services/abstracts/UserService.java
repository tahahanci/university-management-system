package com.hncdev.authservice.services.abstracts;

import com.hncdev.authservice.services.dtos.requests.RegisterStudentRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void add(RegisterStudentRequest registerStudentRequest);
}
