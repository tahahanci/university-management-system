package com.hncdev.studentservice.services.concretes;

import com.hncdev.studentservice.entities.Department;
import com.hncdev.studentservice.repositories.DepartmentRepository;
import com.hncdev.studentservice.services.abstracts.DepartmentService;
import com.hncdev.studentservice.services.core.exception.DepartmentNotFoundException;
import com.hncdev.studentservice.services.dtos.responses.ShowDepartmentInformation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ShowDepartmentInformation getDepartmentInformation(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new DepartmentNotFoundException("Department not found with code: " + departmentCode)
        );
        ShowDepartmentInformation information = new ShowDepartmentInformation();
        information.setDepartmentName(department.getDepartmentName());
        return information;
    }

    @Override
    public void deleteDepartmentById(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new DepartmentNotFoundException("Department not found with id: " + id)
        );
        departmentRepository.delete(department);
    }

}
