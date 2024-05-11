package com.hncdev.studentservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseResponse {

    private String courseName;
    private String courseCode;
    private int credit;
    private int semester;
    private String departmentName;
}
