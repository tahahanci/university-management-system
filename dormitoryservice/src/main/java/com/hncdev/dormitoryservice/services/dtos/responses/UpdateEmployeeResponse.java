package com.hncdev.dormitoryservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEmployeeResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int dormitoryId;
}
