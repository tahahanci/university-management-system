package com.hncdev.dormitoryservice.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilterDormitoryByRequest {

    private String dormitoryId;
    private String dormitoryName;
    private String dormitoryType;
}
