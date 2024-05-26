package com.hncdev.registrationservice.service.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowStudentInfoResponse {

    private String studentId;
    private String studentName;
    private String departmentName;
    private String dormitoryName;
    private List<String> courses;
}
