package com.investv2.In_VestV20.Service;

import com.investv2.In_VestV20.Entity.Stock;
import com.investv2.In_VestV20.Entity.TickerHistory;
import com.investv2.In_VestV20.Entity.TickerResponse;
import com.investv2.In_VestV20.Repository.StockRepository;
import com.investv2.In_VestV20.Repository.TickerResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final TickerResponseRepository tickerResponseRepository;
    private final StockRepository stockRepository;

    @Autowired
    public DashboardService(TickerResponseRepository tickerResponseRepository, StockRepository stockRepository) {
        this.tickerResponseRepository = tickerResponseRepository;
        this.stockRepository = stockRepository;
    }

    //Find the stock by its ticker
    public List<TickerHistory> dataFetch(String ticker) {
        Stock stock = stockRepository.findByTicker(ticker);
        if (stock == null) {
            throw new IllegalArgumentException("Stock not found for ticker: " + ticker);
        }
        return stock.getTickerHistories().stream().toList();
    }
}
