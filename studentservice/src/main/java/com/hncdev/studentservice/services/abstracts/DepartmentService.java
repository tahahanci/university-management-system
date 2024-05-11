package com.hncdev.studentservice.services.abstracts;

import com.hncdev.studentservice.entities.Department;
import com.hncdev.studentservice.services.dtos.responses.ShowDepartmentInformation;

import java.util.Optional;

public interface DepartmentService {

    ShowDepartmentInformation getDepartmentInformation(String departmentCode);

    void deleteDepartmentById(int id);

}
