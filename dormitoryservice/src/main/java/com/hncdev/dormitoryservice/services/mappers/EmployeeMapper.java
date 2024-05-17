package com.hncdev.dormitoryservice.services.mappers;

import com.hncdev.dormitoryservice.entities.Employee;
import com.hncdev.dormitoryservice.services.dtos.requests.AddEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "dormitory.id", source = "addEmployeeRequest.dormitoryId")
    Employee employeeFromAddRequest(AddEmployeeRequest addEmployeeRequest);
}
