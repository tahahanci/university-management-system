package com.hncdev.dormitoryservice.repositories;

import com.hncdev.dormitoryservice.entities.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {

    Optional<Dormitory> findByDormitoryName(String dormitoryName);
}
