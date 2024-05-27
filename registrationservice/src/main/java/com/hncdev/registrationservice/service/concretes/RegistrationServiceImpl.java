package com.hncdev.registrationservice.service.concretes;

import com.hncdev.registrationservice.clients.DormitoryServiceClient;
import com.hncdev.registrationservice.clients.StudentServiceClient;
import com.hncdev.registrationservice.entities.Registration;
import com.hncdev.registrationservice.repository.RegistrationRepository;
import com.hncdev.registrationservice.service.abstracts.RegistrationService;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import com.hncdev.registrationservice.service.dtos.responses.RegisterStudentResponse;
import com.hncdev.registrationservice.service.dtos.responses.ShowStudentInfoResponse;
import com.hncdev.registrationservice.service.mappers.RegistrationMapper;
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
        Registration registration = RegistrationMapper.INSTANCE.registrationFromAddRequest(request);
        registration.setRegistrationDate(LocalDateTime.now());
        registrationRepository.save(registration);
        RegisterStudentResponse response = new RegisterStudentResponse();
        response.setStudentName(studentServiceClient.getStudentNameAndSurname(request.getStudentId()));
        response.setDormitoryName(dormitoryServiceClient.getDormitoryName(request.getDormitoryId()));
        response.setDepartmentName(studentServiceClient.getDepartmentName(request.getStudentId()));
        return response;
    }

    @Override
    public void deleteStudent(String studentId) {
        Registration registration = registrationRepository.findByStudentId(studentId).orElseThrow(
                () -> new IllegalArgumentException("Student not found in registration list")
        );
        registrationRepository.delete(registration);
    }

    @Override
    public ShowStudentInfoResponse showStudentInfo(String studentId) {
        Registration registration = registrationRepository.findByStudentId(studentId).orElseThrow(
                () -> new IllegalArgumentException("Student not found in registration list")
        );

        ShowStudentInfoResponse response = new ShowStudentInfoResponse();
        response.setStudentId(registration.getStudentId());
        response.setStudentName(studentServiceClient.getStudentNameAndSurname(registration.getStudentId()));
        response.setDormitoryName(dormitoryServiceClient.getDormitoryName(registration.getDormitoryId()));
        response.setDepartmentName(studentServiceClient.getDepartmentName(registration.getStudentId()));
        response.setCourses(studentServiceClient.getCourseNames(registration.getStudentId()));
        return response;
    }
}
