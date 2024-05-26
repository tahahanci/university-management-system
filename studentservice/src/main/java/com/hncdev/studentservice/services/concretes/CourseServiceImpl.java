package com.hncdev.studentservice.services.concretes;

import com.hncdev.studentservice.entities.Course;
import com.hncdev.studentservice.entities.Department;
import com.hncdev.studentservice.repositories.CourseRepository;
import com.hncdev.studentservice.repositories.DepartmentRepository;
import com.hncdev.studentservice.repositories.StudentRepository;
import com.hncdev.studentservice.services.abstracts.CourseService;
import com.hncdev.studentservice.services.dtos.requests.CreateCourseRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateCourseRequest;
import com.hncdev.studentservice.services.dtos.responses.CreateCourseResponse;
import com.hncdev.studentservice.services.dtos.responses.ShowCourseInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateCourseResponse;
import com.hncdev.studentservice.services.mappers.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void deleteCourse(String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) {
        Course course = CourseMapper.INSTANCE.courseFromCreateRequest(createCourseRequest);
        Department department = departmentRepository.findById(createCourseRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        course.setDepartment(department);
        courseRepository.save(course);
        return CourseMapper.INSTANCE.fromCourse(course);
    }

    @Override
    public UpdateCourseResponse updateCourse(String courseCode, UpdateCourseRequest request) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Course updatedCourse = CourseMapper.INSTANCE.courseFromUpdateRequest(course, request);
        updatedCourse = courseRepository.save(updatedCourse);
        return CourseMapper.INSTANCE.fromCourseForUpdate(updatedCourse);
    }

    @Override
    public ShowCourseInformation getCourseInformation(int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        ShowCourseInformation info = new ShowCourseInformation();
        info.setCourseCode(course.getCourseCode());
        info.setCourseName(course.getCourseName());
        info.setCredit(course.getCredit());
        info.setSemester(course.getSemester());
        return info;
    }
}
