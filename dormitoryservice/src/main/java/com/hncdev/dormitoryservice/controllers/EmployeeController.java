package com.hncdev.dormitoryservice.controllers;

import com.hncdev.dormitoryservice.services.abstracts.EmployeeService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.SearchEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.SearchEmployeeResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployee(@RequestBody AddEmployeeRequest request) {
        employeeService.addEmployee(request);
    }

    @PutMapping("update/{employeeId}")
    public UpdateEmployeeResponse updateEmployee(@PathVariable String employeeId,
                                                 @RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(employeeId, request);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PostMapping("/search")
    public List<SearchEmployeeResponse> search(@RequestBody SearchEmployeeRequest request) {
        return employeeService.search(request);
    }
}
