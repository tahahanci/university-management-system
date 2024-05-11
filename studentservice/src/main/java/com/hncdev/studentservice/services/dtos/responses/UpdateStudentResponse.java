package com.hncdev.studentservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentResponse {

    private String studentId;
    private String firstName;
    private String lastName;
    private String departmentName;

}
