package com.investv2.In_VestV20.Controller;


import com.investv2.In_VestV20.Service.DashboardServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    private final DashboardServlet dashboardServlet;

    @Autowired
    public DashboardController(DashboardServlet dashboardServlet) {
        this.dashboardServlet = dashboardServlet;
    }

    @GetMapping("/Dashboard")
    public String getPage() {
        return "Dashboard";
    }

    @GetMapping("/Analytics")
    public ModelAndView getDashboard(@RequestParam String ticker) {
        ModelAndView mav = new ModelAndView();
        dashboardServlet.dataFetch(ticker);



        return mav;
    }
}
