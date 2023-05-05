package com.DBTeam.usageWatcher.controller;

import com.DBTeam.usageWatcher.dto.UsageResponse;
import com.DBTeam.usageWatcher.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
public class UsageController {

    private final UsageService usageService;

    @GetMapping
    public ResponseEntity<List<UsageResponse>> getUsageList() {
        List<UsageResponse> usageResponseList = usageService.findItems();

        return ResponseEntity.ok().body(usageResponseList);
    }
}
