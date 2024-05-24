package com.hncdev.dormitoryservice.services.abstracts;

import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.FilterDormitoryByRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.AddDormitoryResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.FilterDormitoryByResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateDormitoryResponse;

import java.util.List;

public interface DormitoryService {

    AddDormitoryResponse addDormitory(AddDormitoryRequest request);

    void removeDormitory(String dormitoryId);

    List<ListDormitoryByType> findByDormitoryType(String dormitoryType);

    List<FilterDormitoryByResponse> search(FilterDormitoryByRequest request);

    UpdateDormitoryResponse updateDormitory(String dormitoryId, UpdateDormitoryRequest request);

    String getDormitoryName(String dormitoryId);

}
