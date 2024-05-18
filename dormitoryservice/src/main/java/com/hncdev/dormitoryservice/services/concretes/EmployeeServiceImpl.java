package com.hncdev.dormitoryservice.services.concretes;

import com.hncdev.dormitoryservice.entities.Employee;
import com.hncdev.dormitoryservice.repositories.DormitoryRepository;
import com.hncdev.dormitoryservice.repositories.EmployeeRepository;
import com.hncdev.dormitoryservice.services.abstracts.EmployeeService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateEmployeeResponse;
import com.hncdev.dormitoryservice.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DormitoryRepository dormitoryRepository;

    @Override
    public void addEmployee(AddEmployeeRequest request) {
        Employee employee = EmployeeMapper.INSTANCE.employeeFromAddRequest(request);
        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.save(employee);
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(String employeeId, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
        employee = EmployeeMapper.INSTANCE.employeeFromUpdateRequest(employee, request);
        employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.fromEmployeeForUpdate(employee);
    }
}
