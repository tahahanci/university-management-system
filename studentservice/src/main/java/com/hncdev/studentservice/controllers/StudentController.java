package com.hncdev.studentservice.controllers;

import com.hncdev.studentservice.services.abstracts.StudentService;
import com.hncdev.studentservice.services.dtos.requests.CreateStudentRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateStudentRequest;
import com.hncdev.studentservice.services.dtos.responses.ShowStudentInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateStudentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public void createStudent(@RequestBody CreateStudentRequest request) {
        studentService.createStudent(request);
    }

    @GetMapping("/getStudentInfo/{studentId}")
    public ShowStudentInformation getStudentInformation(@PathVariable String studentId) {
        return studentService.getStudentInformation(studentId);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable String studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/update/{studentId}")
    public UpdateStudentResponse updateStudent(@PathVariable String studentId,
                                               @RequestBody UpdateStudentRequest request) {
        return studentService.updateStudent(studentId, request);
    }

    @PutMapping("/enroll/{courseId}/{studentId}")
    public void enrollCourse(@PathVariable int courseId, @PathVariable int studentId) {
        studentService.addCourse(courseId, studentId);
    }


}
