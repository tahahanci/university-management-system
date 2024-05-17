package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;

public interface EmployeeService {

    void addEmployee(AddEmployeeRequest request);
}
