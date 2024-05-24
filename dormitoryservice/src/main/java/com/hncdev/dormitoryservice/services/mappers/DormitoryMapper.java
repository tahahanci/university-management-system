package com.hncdev.dormitoryservice.services.mappers;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.AddDormitoryResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateDormitoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DormitoryMapper {

    DormitoryMapper INSTANCE = Mappers.getMapper(DormitoryMapper.class);

    Dormitory dormitoryFromAddRequest(AddDormitoryRequest addDormitoryRequest);

    AddDormitoryResponse addDormitoryResponseFromDormitory(Dormitory dormitory);

    Dormitory dormitoryFromUpdateRequest(@MappingTarget Dormitory dormitory,
                                         UpdateDormitoryRequest updateDormitoryRequest);

    UpdateDormitoryResponse updateDormitoryResponseFromDormitory(Dormitory dormitory);
}
