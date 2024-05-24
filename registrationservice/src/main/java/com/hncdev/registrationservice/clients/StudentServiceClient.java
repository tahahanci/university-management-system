package com.hncdev.registrationservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "studentservice")
public interface StudentServiceClient {

    @GetMapping("/api/v1/students/getStudentNameAndSurname/{studentId}")
    String getStudentNameAndSurname(@PathVariable("studentId") String studentId);

    @GetMapping("/api/v1/students/getDepartmentName/{studentId}")
    String getDepartmentName(@PathVariable("studentId") String studentId);

}
