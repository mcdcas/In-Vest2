package com.investv2.In_VestV20.Controller;


import com.investv2.In_VestV20.Entity.TickerHistory;
import com.investv2.In_VestV20.Entity.TickerResponse;
import com.investv2.In_VestV20.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/Dashboard")
    public String getPage() {
        return "Dashboard";
    }

    @GetMapping("/Analytics")
    public ModelAndView getDashboard(@RequestParam String ticker) {
        ModelAndView mav = new ModelAndView("Dashboard");

        try {
            // Fetch the stock data using the service
            List<TickerHistory> stockData = dashboardService.dataFetch(ticker);

            // Add stockData to the ModelAndView so it can be rendered in Thymeleaf
            mav.addObject("stockData", stockData);
            mav.addObject("ticker", ticker); // Add ticker to display in the view
        } catch (IllegalArgumentException e) {
            mav.addObject("errorMessage", e.getMessage());
        }

        return mav;
    }

    @GetMapping("/api/stockData")
    public ResponseEntity<List<TickerHistory>> getStockData(@RequestParam String ticker) {
        List<TickerHistory> stockData = dashboardService.dataFetch(ticker);
        return ResponseEntity.ok(stockData);
    }
}
