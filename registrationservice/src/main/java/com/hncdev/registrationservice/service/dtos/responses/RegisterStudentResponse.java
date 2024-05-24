package com.hncdev.registrationservice.service.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterStudentResponse {

    private String studentName;
    private String studentLastName;
    private String departmentName;
    private String dormitoryName;

}
