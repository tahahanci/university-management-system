package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateEmployeeResponse;

public interface EmployeeService {

    void addEmployee(AddEmployeeRequest request);

    UpdateEmployeeResponse updateEmployee(String employeeId, UpdateEmployeeRequest request);
}
