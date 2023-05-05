package com.DBTeam.usageWatcher.service;

import com.DBTeam.usageWatcher.domain.Usage;
import com.DBTeam.usageWatcher.dto.UsageResponse;
import com.DBTeam.usageWatcher.repository.UsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsageService {

    private final UsageRepository usageRepository;
    private final int limit = 10;

    // DB에서 최근 N개의 데이터를 조회
    public List<UsageResponse> findItems() {
        List<Usage> usageList = usageRepository.findUsages(PageRequest.of(0, this.limit));
        List<UsageResponse> usageResponseList = new ArrayList<>();

        for(Usage usage : usageList) {
            usageResponseList.add(usageEntityToUsageResponseDTO(usage));
        }

        return usageResponseList;
    }

    private UsageResponse usageEntityToUsageResponseDTO(Usage usageEntity) {
        return new UsageResponse(usageEntity.getUsageId(), usageEntity.getInstanceName(),
                usageEntity.getUsageTime(), usageEntity.getCpuUsage(), usageEntity.getMemoryUsage());
    }
}
