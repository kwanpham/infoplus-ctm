package com.infoplusvn.ctm.controller.v1.ui;

import com.infoplusvn.ctm.service.ContractDetailService;
import com.infoplusvn.ctm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContractDetailService contractDetailService;



    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("upcommingPurchase" , contractDetailService.getAllUpcomingPurchase(PageRequest.of(0,3)));
        model.addAttribute("upcommingSale" , contractDetailService.getAllUpcomingSale(PageRequest.of(0,3)));
        return "index";
    }

    @GetMapping("/indexa")
    public String index() {
        return "indexa";
    }

}
