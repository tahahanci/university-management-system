package com.hncdev.dormitoryservice.services.concretes;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.repositories.DormitoryRepository;
import com.hncdev.dormitoryservice.services.abstracts.DormitoryService;
import com.hncdev.dormitoryservice.services.core.exception.DormitoryNotFoundException;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.FilterDormitoryByRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.*;
import com.hncdev.dormitoryservice.services.mappers.DormitoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Override
    public AddDormitoryResponse addDormitory(AddDormitoryRequest request) {
        Dormitory dormitory = DormitoryMapper.INSTANCE.dormitoryFromAddRequest(request);
        dormitoryRepository.save(dormitory);
        return DormitoryMapper.INSTANCE.addDormitoryResponseFromDormitory(dormitory);
    }

    @Override
    public void removeDormitory(String dormitoryId) {
        Dormitory dormitory = dormitoryRepository.findByDormitoryId(dormitoryId)
                .orElseThrow(() -> new IllegalArgumentException("Dormitory not found with id: " + dormitoryId));
        dormitoryRepository.delete(dormitory);
    }

    @Override
    public List<ListDormitoryByType> findByDormitoryType(String dormitoryType) {
        return dormitoryRepository.findByDormitoryType(dormitoryType);
    }

    @Override
    public List<FilterDormitoryByResponse> search(FilterDormitoryByRequest request) {
        return dormitoryRepository.search(request);
    }

    @Override
    public UpdateDormitoryResponse updateDormitory(String dormitoryName, UpdateDormitoryRequest request) {
        Dormitory dormitory = dormitoryRepository.findByDormitoryName(dormitoryName).orElseThrow(
                () -> new DormitoryNotFoundException("Dormitory not found with name: " + dormitoryName));
        dormitory = DormitoryMapper.INSTANCE.dormitoryFromUpdateRequest(dormitory, request);
        dormitoryRepository.save(dormitory);
        return DormitoryMapper.INSTANCE.updateDormitoryResponseFromDormitory(dormitory);
    }

}
