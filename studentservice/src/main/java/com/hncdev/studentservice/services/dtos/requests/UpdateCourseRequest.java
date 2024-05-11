package com.hncdev.studentservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {

    private String courseName;
    private String courseCode;
    private int credit;
    private int semester;
}
