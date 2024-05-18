package com.hncdev.dormitoryservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEmployeeRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int dormitoryId;
}
