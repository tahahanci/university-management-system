package com.hncdev.studentservice.services.abstracts;

import com.hncdev.studentservice.entities.Course;
import com.hncdev.studentservice.entities.Student;
import com.hncdev.studentservice.services.dtos.requests.CreateCourseRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateCourseRequest;
import com.hncdev.studentservice.services.dtos.responses.CreateCourseResponse;
import com.hncdev.studentservice.services.dtos.responses.ShowCourseInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateCourseResponse;

import java.util.List;

public interface CourseService {

    void deleteCourse(String courseCode);

    CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest);

    UpdateCourseResponse updateCourse(String courseCode, UpdateCourseRequest updateCourseRequest);

    ShowCourseInformation getCourseInformation(int courseId);
}
