package com.hncdev.studentservice.services.mappers;

import com.hncdev.studentservice.entities.Student;
import com.hncdev.studentservice.services.dtos.requests.CreateStudentRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateStudentRequest;
import com.hncdev.studentservice.services.dtos.responses.ShowStudentInformation;
import com.hncdev.studentservice.services.dtos.responses.UpdateStudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "department.id", source = "createStudentRequest.departmentId")
    Student studentFromCreateRequest(CreateStudentRequest createStudentRequest);

    @Mapping(target = "departmentName", source = "student.department.departmentName")
    @Mapping(target = "courses", source = "student.courses")
    ShowStudentInformation fromStudent(Student student);

    @Mapping(target = "student.department.id", source = "updateStudentRequest.departmentId")
    Student updateStudentFromRequest(@MappingTarget Student student, UpdateStudentRequest updateStudentRequest);

    @Mapping(target = "departmentName", source = "student.department.departmentName")
    UpdateStudentResponse fromStudentForUpdate(Student student);
}
