package com.hncdev.registrationservice.service.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudentResponse {

    private String studentName;
    private String dormitoryName;
    private String departmentName;

}
