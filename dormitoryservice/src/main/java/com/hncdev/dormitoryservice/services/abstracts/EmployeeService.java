package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.SearchEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.SearchEmployeeResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateEmployeeResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {

    void addEmployee(AddEmployeeRequest request);

    UpdateEmployeeResponse updateEmployee(String employeeId, UpdateEmployeeRequest request);

    void deleteEmployee(String employeeId);

    List<SearchEmployeeResponse> search(SearchEmployeeRequest request);
}
