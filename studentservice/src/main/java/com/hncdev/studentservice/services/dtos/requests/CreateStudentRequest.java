package com.hncdev.studentservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private int departmentId;

}
