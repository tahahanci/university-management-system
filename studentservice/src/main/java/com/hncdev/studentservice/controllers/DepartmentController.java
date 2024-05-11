package com.hncdev.studentservice.controllers;

import com.hncdev.studentservice.services.abstracts.DepartmentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }
}
