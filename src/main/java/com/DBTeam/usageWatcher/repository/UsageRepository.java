package com.DBTeam.usageWatcher.repository;

import com.DBTeam.usageWatcher.domain.Usage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsageRepository extends JpaRepository<Usage, Long> {
    // JPQL 문법, Entity에 대해 쿼리 수행
    @Query("select u from Usage u order by u.usageTime desc")
    List<Usage> findUsages(Pageable pageable);
}
