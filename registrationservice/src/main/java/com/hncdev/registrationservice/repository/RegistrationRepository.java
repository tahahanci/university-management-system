package com.hncdev.registrationservice.repository;

import com.hncdev.registrationservice.entities.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Optional<Registration> findByStudentId(String studentId);
}
