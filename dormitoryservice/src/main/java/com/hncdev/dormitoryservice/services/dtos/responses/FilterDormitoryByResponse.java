package com.hncdev.dormitoryservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilterDormitoryByResponse {

    private String dormitoryId;
    private String dormitoryName;
    private String dormitoryType;
    private int capacity;
}
