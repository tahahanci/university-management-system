package com.hncdev.dormitoryservice.services.concretes;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.repositories.DormitoryRepository;
import com.hncdev.dormitoryservice.services.abstracts.DormitoryService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.AddDormitoryResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Override
    public AddDormitoryResponse addDormitory(AddDormitoryRequest request) {
        Dormitory dormitory = new Dormitory();
        dormitory.setDormitoryId(request.getDormitoryId());
        dormitory.setDormitoryName(request.getDormitoryName());
        dormitory.setDormitoryType(request.getDormitoryType());
        dormitory.setCapacity(request.getCapacity());
        dormitoryRepository.save(dormitory);
        AddDormitoryResponse response = new AddDormitoryResponse(dormitory.getDormitoryId(),
                dormitory.getDormitoryName(), dormitory.getDormitoryType(), dormitory.getCapacity());
        return response;
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
}
