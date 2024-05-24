package com.hncdev.registrationservice.service.abstracts;

import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;

public interface RegistrationService {

    void registerStudent(RegisterStudentRequest request);

}
