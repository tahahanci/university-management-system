package com.hncdev.dormitoryservice.controllers;

import com.hncdev.dormitoryservice.services.abstracts.EmployeeService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployee(@RequestBody AddEmployeeRequest request) {
        employeeService.addEmployee(request);
    }
}
