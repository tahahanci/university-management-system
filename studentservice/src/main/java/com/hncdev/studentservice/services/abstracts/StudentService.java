package com.hncdev.studentservice.services.abstracts;

import com.hncdev.studentservice.services.dtos.requests.CreateStudentRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateStudentRequest;
import com.hncdev.studentservice.services.dtos.responses.ShowStudentInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateStudentResponse;

import java.util.List;

public interface StudentService {

    void createStudent(CreateStudentRequest request);

    ShowStudentInformation getStudentInformation(String studentId);

    void deleteStudent(String studentId);

    UpdateStudentResponse updateStudent(String studentId, UpdateStudentRequest request);

    void addCourse(Integer courseId, Integer studentId);

    String getStudentNameAndSurname(String studentId);

    String getDepartmentName(String studentId);

    List<String> getCourseNames(String studentId);
}
