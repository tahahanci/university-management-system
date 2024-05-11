package com.hncdev.studentservice.controllers;

import com.hncdev.studentservice.services.abstracts.CourseService;
import com.hncdev.studentservice.services.dtos.requests.CreateCourseRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateCourseRequest;
import com.hncdev.studentservice.services.dtos.responses.CreateCourseResponse;
import com.hncdev.studentservice.services.dtos.responses.ShowCourseInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateCourseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping("delete/{courseCode}")
    public void deleteCourse(@PathVariable String courseCode) {
        courseService.deleteCourse(courseCode);
    }

    @PostMapping("/create")
    public CreateCourseResponse createCourse(@RequestBody CreateCourseRequest request) {
        return courseService.createCourse(request);
    }

    @PutMapping("/update/{courseCode}")
    public UpdateCourseResponse updateCourse(@PathVariable String courseCode,
                                             @RequestBody UpdateCourseRequest request) {
        return courseService.updateCourse(courseCode, request);
    }

    @GetMapping("/info/{courseId}")
    public ShowCourseInformation getCourseInformation(@PathVariable int courseId) {
        return courseService.getCourseInformation(courseId);
    }

}
