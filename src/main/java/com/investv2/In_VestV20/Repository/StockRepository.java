package com.investv2.In_VestV20.Repository;

import com.investv2.In_VestV20.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByTicker(String ticker);
}
