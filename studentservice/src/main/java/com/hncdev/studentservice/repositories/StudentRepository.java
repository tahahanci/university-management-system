package com.hncdev.studentservice.repositories;

import com.hncdev.studentservice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findById(Integer id);

    Optional<Student> findByStudentId(String studentId);
}
