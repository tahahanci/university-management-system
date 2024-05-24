package com.hncdev.registrationservice.service.concretes;

import com.hncdev.registrationservice.entities.Registration;
import com.hncdev.registrationservice.repository.RegistrationRepository;
import com.hncdev.registrationservice.service.abstracts.RegistrationService;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public void registerStudent(RegisterStudentRequest request) {
        Registration registration = new Registration();
        registration.setStudentId(request.getStudentId());
        registration.setDormitoryId(request.getDormitoryId());
        registration.setRegistrationDate(LocalDateTime.now());
        registrationRepository.save(registration);
    }
}
