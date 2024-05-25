package com.hncdev.registrationservice.service.concretes;

import com.hncdev.registrationservice.clients.DormitoryServiceClient;
import com.hncdev.registrationservice.clients.StudentServiceClient;
import com.hncdev.registrationservice.entities.Registration;
import com.hncdev.registrationservice.repository.RegistrationRepository;
import com.hncdev.registrationservice.service.abstracts.RegistrationService;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import com.hncdev.registrationservice.service.dtos.responses.RegisterStudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final DormitoryServiceClient dormitoryServiceClient;
    private final StudentServiceClient studentServiceClient;

    @Override
    public RegisterStudentResponse registerStudent(RegisterStudentRequest request) {
        Registration registration = new Registration();
        registration.setStudentId(request.getStudentId());
        registration.setDormitoryId(request.getDormitoryId());
        registration.setRegistrationDate(LocalDateTime.now());
        registrationRepository.save(registration);
        RegisterStudentResponse response = new RegisterStudentResponse();
        response.setStudentName(studentServiceClient.getStudentNameAndSurname(request.getStudentId()));
        response.setDormitoryName(dormitoryServiceClient.getDormitoryName(request.getDormitoryId()));
        response.setDepartmentName(studentServiceClient.getDepartmentName(request.getStudentId()));
        return response;
    }
}
