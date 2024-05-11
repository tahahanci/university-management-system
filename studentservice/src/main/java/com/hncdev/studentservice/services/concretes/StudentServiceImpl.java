package com.hncdev.studentservice.services.concretes;

import com.hncdev.studentservice.entities.Course;
import com.hncdev.studentservice.entities.Department;
import com.hncdev.studentservice.entities.Student;
import com.hncdev.studentservice.repositories.CourseRepository;
import com.hncdev.studentservice.repositories.DepartmentRepository;
import com.hncdev.studentservice.repositories.StudentRepository;
import com.hncdev.studentservice.services.abstracts.StudentService;
import com.hncdev.studentservice.services.core.exception.CourseNotFoundException;
import com.hncdev.studentservice.services.core.exception.DepartmentNotFoundException;
import com.hncdev.studentservice.services.core.exception.StudentNotFoundException;
import com.hncdev.studentservice.services.dtos.requests.CreateStudentRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateStudentRequest;
import com.hncdev.studentservice.services.dtos.responses.ShowStudentInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateStudentResponse;
import com.hncdev.studentservice.services.mappers.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository,
                              CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void createStudent(CreateStudentRequest request) {
        Student student = StudentMapper.INSTANCE.studentFromCreateRequest(request);
        student.setStudentId(UUID.randomUUID().toString());
        studentRepository.save(student);
    }

    @Override
    public ShowStudentInformation getStudentInformation(String studentId) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new StudentNotFoundException("Student not found")
        );
        return StudentMapper.INSTANCE.fromStudent(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new StudentNotFoundException("Student not found")
        );
        studentRepository.delete(student);
    }

    @Override
    public UpdateStudentResponse updateStudent(String studentId, UpdateStudentRequest request) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new StudentNotFoundException("Student not found")
        );
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                () -> new DepartmentNotFoundException("Department not found")
        );
        student.setDepartment(department);
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        studentRepository.save(student);
        return StudentMapper.INSTANCE.fromStudentForUpdate(student);
    }

    @Override
    public void addCourse(Integer courseId, Integer studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new CourseNotFoundException("Course not found")
        );
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException("Student not found")
        );

        student.addCourse(course);
        studentRepository.save(student);
    }
}
