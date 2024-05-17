package com.hncdev.dormitoryservice.services.concretes;

import com.hncdev.dormitoryservice.entities.Employee;
import com.hncdev.dormitoryservice.repositories.EmployeeRepository;
import com.hncdev.dormitoryservice.services.abstracts.EmployeeService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(AddEmployeeRequest request) {
        Employee employee = EmployeeMapper.INSTANCE.employeeFromAddRequest(request);
        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.save(employee);
    }
}
