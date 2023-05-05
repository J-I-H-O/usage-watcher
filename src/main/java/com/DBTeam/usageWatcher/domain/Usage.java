package com.DBTeam.usageWatcher.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Usage Entity
@Entity
@Getter
@NoArgsConstructor
public class Usage {

    @Id // PK로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    private Long usageId;

    private String instanceName;

    private LocalDateTime usageTime;

    private Long CpuUsage;

    private Long MemoryUsage;
}
