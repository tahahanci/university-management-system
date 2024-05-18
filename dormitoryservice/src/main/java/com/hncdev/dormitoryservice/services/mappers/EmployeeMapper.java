package com.hncdev.dormitoryservice.services.mappers;

import com.hncdev.dormitoryservice.entities.Employee;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateEmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "dormitory.id", source = "addEmployeeRequest.dormitoryId")
    Employee employeeFromAddRequest(AddEmployeeRequest addEmployeeRequest);

    @Mapping(target = "dormitory.id", source = "request.dormitoryId")
    Employee employeeFromUpdateRequest(@MappingTarget Employee employee, UpdateEmployeeRequest request);

    @Mapping(target = "dormitoryId", source = "employee.dormitory.id")
    UpdateEmployeeResponse fromEmployeeForUpdate(Employee employee);
}
