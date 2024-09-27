//package com.investv2.In_VestV20.Controller;
//
//import com.investv2.In_VestV20.Entity.TickerHistory;
//import com.investv2.In_VestV20.Service.DashboardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class StockDataController {
//
//    private final DashboardService dashboardService;
//
//    @Autowired
//    public StockDataController(DashboardService dashboardService) {
//        this.dashboardService = dashboardService;
//    }
//
//    @GetMapping("/api/stockData")
//    public ResponseEntity<List<TickerHistory>> getStockData(@RequestParam String ticker) {
//        List<TickerHistory> stockData = dashboardService.dataFetch(ticker);
//        return ResponseEntity.ok(stockData);
//    }
//}
