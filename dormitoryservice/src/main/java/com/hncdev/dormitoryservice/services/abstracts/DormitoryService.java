package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.AddDormitoryResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;

import java.util.List;

public interface DormitoryService {

    AddDormitoryResponse addDormitory(AddDormitoryRequest request);

    void removeDormitory(String dormitoryId);

    List<ListDormitoryByType> findByDormitoryType(String dormitoryType);

}
