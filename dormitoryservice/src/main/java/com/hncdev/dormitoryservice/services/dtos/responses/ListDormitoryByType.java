package com.hncdev.dormitoryservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class ListDormitoryByType {

    private String dormitoryId;
    private String dormitoryName;
    private int capacity;

}
