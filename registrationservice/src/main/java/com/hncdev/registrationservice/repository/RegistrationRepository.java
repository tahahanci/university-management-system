package com.hncdev.registrationservice.repository;

import com.hncdev.registrationservice.entities.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepository extends MongoRepository<Registration, String> {
}
