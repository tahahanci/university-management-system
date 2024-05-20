package com.hncdev.dormitoryservice.repositories;

import com.hncdev.dormitoryservice.entities.Dormitory;
import com.hncdev.dormitoryservice.services.dtos.requests.FilterDormitoryByRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.FilterDormitoryByResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DormitoryRepository extends JpaRepository<Dormitory, Integer> {

    Optional<Dormitory> findByDormitoryName(String dormitoryName);

    Optional<Dormitory> findByDormitoryId(String dormitoryId);

    @Query("SELECT new com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType(" +
            "d.dormitoryId, d.dormitoryName, d.capacity)" +
            " FROM Dormitory d WHERE d.dormitoryType = :dormitoryType")
    List<ListDormitoryByType> findByDormitoryType(String dormitoryType);

    @Query("SELECT new com.hncdev.dormitoryservice.services.dtos.responses.FilterDormitoryByResponse(" +
            "d.dormitoryId, d.dormitoryName, d.dormitoryType, d.capacity)" +
            " FROM Dormitory d" +
            " WHERE (:#{#request.dormitoryId} IS NULL OR d.dormitoryId = :#{#request.dormitoryId})" +
            " AND (:#{#request.dormitoryName} IS NULL OR d.dormitoryName = :#{#request.dormitoryName})" +
            " AND (:#{#request.dormitoryType} IS NULL OR d.dormitoryType = :#{#request.dormitoryType})")
    List<FilterDormitoryByResponse> search(FilterDormitoryByRequest request);
}
