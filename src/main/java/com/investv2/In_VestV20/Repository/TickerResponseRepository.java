package com.investv2.In_VestV20.Repository;

import com.investv2.In_VestV20.Entity.TickerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TickerResponseRepository extends JpaRepository<TickerHistory, Integer> {
}
