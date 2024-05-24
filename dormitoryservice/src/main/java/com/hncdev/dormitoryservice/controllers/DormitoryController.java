package com.hncdev.dormitoryservice.controllers;

import com.hncdev.dormitoryservice.services.abstracts.DormitoryService;
import com.hncdev.dormitoryservice.services.dtos.requests.AddDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.FilterDormitoryByRequest;
import com.hncdev.dormitoryservice.services.dtos.requests.UpdateDormitoryRequest;
import com.hncdev.dormitoryservice.services.dtos.responses.FilterDormitoryByResponse;
import com.hncdev.dormitoryservice.services.dtos.responses.ListDormitoryByType;
import com.hncdev.dormitoryservice.services.dtos.responses.UpdateDormitoryResponse;
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

    @PostMapping("/search")
    public List<FilterDormitoryByResponse> search(@RequestBody FilterDormitoryByRequest request) {
        return dormitoryService.search(request);
    }

    @PutMapping("/update/{dormitoryName}")
    public UpdateDormitoryResponse updateDormitory(@PathVariable String dormitoryName,
                                                   @RequestBody UpdateDormitoryRequest request) {
        return dormitoryService.updateDormitory(dormitoryName, request);
    }

    @GetMapping("/getDormitoryName/{dormitoryId}")
    public String getDormitoryName(@PathVariable String dormitoryId) {
        return dormitoryService.getDormitoryName(dormitoryId);
    }
}
