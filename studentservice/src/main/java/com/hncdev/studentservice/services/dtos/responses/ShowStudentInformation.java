package com.hncdev.studentservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowStudentInformation {

    private String studentId;
    private String firstName;
    private String lastName;
    private String departmentName;
    private List<ShowCourseInformation> courses;

}
