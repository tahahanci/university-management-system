package com.hncdev.studentservice.repositories;

import com.hncdev.studentservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByDepartmentCode(String departmentCode);

    Optional<Department> findById(int id);
}
