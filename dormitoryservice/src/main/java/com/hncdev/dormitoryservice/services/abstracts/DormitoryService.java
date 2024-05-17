package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;

public interface DormitoryService {

    void addDormitory(AddDormitoryRequest request);
}
