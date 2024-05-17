package com.hncdev.dormitoryservice.services.concretes;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.repositories.DormitoryRepository;
import com.hncdev.dormitoryservice.services.abstracts.DormitoryService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Override
    public void addDormitory(AddDormitoryRequest request) {
        Dormitory dormitory = new Dormitory();
        dormitory.setDormitoryId(request.getDormitoryId());
        dormitory.setDormitoryName(request.getDormitoryName());
        dormitory.setDormitoryType(request.getDormitoryType());
        dormitory.setCapacity(request.getCapacity());
        dormitoryRepository.save(dormitory);
    }
}
