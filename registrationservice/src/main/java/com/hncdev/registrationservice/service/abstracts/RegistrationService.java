package com.hncdev.registrationservice.service.abstracts;

import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import com.hncdev.registrationservice.service.dtos.responses.RegisterStudentResponse;
import com.hncdev.registrationservice.service.dtos.responses.ShowStudentInfoResponse;

public interface RegistrationService {

    RegisterStudentResponse registerStudent(RegisterStudentRequest request);

    void deleteStudent(String studentId);

    ShowStudentInfoResponse showStudentInfo(String studentId);

}
