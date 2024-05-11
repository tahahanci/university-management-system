package com.hncdev.studentservice.repositories;

import com.hncdev.studentservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findById(Integer id);

    Optional<Course> findByCourseCode(String courseCode);
}
