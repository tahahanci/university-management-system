package com.hncdev.dormitoryservice.repositories;

import com.hncdev.dormitoryservice.entities.Dormitory;
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
}
