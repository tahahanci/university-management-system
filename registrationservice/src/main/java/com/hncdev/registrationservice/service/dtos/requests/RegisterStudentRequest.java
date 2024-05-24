package com.hncdev.registrationservice.service.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterStudentRequest {

    private String studentId;
    private String dormitoryId;

}
