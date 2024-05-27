package com.hncdev.registrationservice.service.mappers;

import com.hncdev.registrationservice.entities.Registration;
import com.hncdev.registrationservice.service.dtos.requests.RegisterStudentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);

    Registration registrationFromAddRequest(RegisterStudentRequest request);
}
