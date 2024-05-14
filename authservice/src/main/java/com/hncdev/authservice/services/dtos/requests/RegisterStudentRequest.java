package com.hncdev.authservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterStudentRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
