package com.hncdev.dormitoryservice.repositories;

import com.hncdev.dormitoryservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId(String employeeId);
}
