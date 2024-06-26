package com.hncdev.registrationservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dormitoryservice")
public interface DormitoryServiceClient {

    @GetMapping("/api/v1/dormitories/getDormitoryName/{dormitoryId}")
    String getDormitoryName(@PathVariable("dormitoryId") String dormitoryId);
}
