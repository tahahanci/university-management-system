package com.hncdev.registrationservice.service.abstracts;

import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import com.hncdev.registrationservice.service.dtos.responses.RegisterStudentResponse;

public interface RegistrationService {

    RegisterStudentResponse registerStudent(RegisterStudentRequest request);

}
