package com.hncdev.studentservice.services.mappers;

import com.hncdev.studentservice.entities.Course;
import com.hncdev.studentservice.services.dtos.requests.CreateCourseRequest;
import com.hncdev.studentservice.services.dtos.requests.UpdateCourseRequest;
import com.hncdev.studentservice.services.dtos.responses.CreateCourseResponse;
import com.hncdev.studentservice.services.dtos.responses.UpdateCourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "department.id", source = "createCourseRequest.departmentId")
    Course courseFromCreateRequest(CreateCourseRequest createCourseRequest);

    @Mapping(target = "departmentName", source = "course.department.departmentName")
    CreateCourseResponse fromCourse(Course course);

    Course courseFromUpdateRequest(@MappingTarget Course course , UpdateCourseRequest updateCourseRequest);

    UpdateCourseResponse fromCourseForUpdate(Course course);
}
