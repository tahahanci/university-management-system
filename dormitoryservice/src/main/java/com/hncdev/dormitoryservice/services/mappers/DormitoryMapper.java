package com.hncdev.dormitoryservice.services.mappers;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.AddDormitoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DormitoryMapper {

    DormitoryMapper INSTANCE = Mappers.getMapper(DormitoryMapper.class);

    Dormitory dormitoryFromAddRequest(AddDormitoryRequest addDormitoryRequest);

    AddDormitoryResponse addDormitoryResponseFromDormitory(Dormitory dormitory);
}
