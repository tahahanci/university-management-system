package com.hncdev.dormitoryservice.controllers;

import com.hncdev.dormitoryservice.services.abstracts.DormitoryService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dormitories")
@RequiredArgsConstructor
public class DormitoryController {

    private final DormitoryService dormitoryService;

    @PostMapping("/add")
    public void addDormitory(@RequestBody AddDormitoryRequest request) {
        dormitoryService.addDormitory(request);
    }

    @DeleteMapping("/remove/{dormitoryId}")
    public void removeDormitory(@PathVariable String dormitoryId) {
        dormitoryService.removeDormitory(dormitoryId);
    }

    @GetMapping("/type/{dormitoryType}")
    public List<ListDormitoryByType> findByDormitoryType(@PathVariable String dormitoryType) {
        return dormitoryService.findByDormitoryType(dormitoryType);
    }
}
