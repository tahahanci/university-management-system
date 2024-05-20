package com.hncdev.dormitoryservice.repositories;

import com.hncdev.dormitoryservice.entities.Employee;
import com.hncdev.dormitoryservice.services.dtos.requests.SearchEmployeeRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.SearchEmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId(String employeeId);

    @Query("SELECT new com.hncdev.dormitoryservice.services.dtos.responses.SearchEmployeeResponse(" +
            "e.employeeId, e.firstName, e.lastName, e.email, e.phoneNumber)" +
            "FROM Employee e " +
            "WHERE (:#{#request.employeeId} IS NULL OR e.employeeId = :#{#request.employeeId})" +
            "AND (:#{#request.firstName} IS NULL OR e.firstName = :#{#request.firstName})" +
            "AND (:#{#request.lastName} IS NULL OR e.lastName = :#{#request.lastName})" +
            "AND (:#{#request.email} IS NULL OR e.email = :#{#request.email})")
    List<SearchEmployeeResponse> search(SearchEmployeeRequest request);
}
