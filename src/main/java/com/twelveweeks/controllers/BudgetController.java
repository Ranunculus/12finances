package com.twelveweeks.controllers;

import com.twelveweeks.service.TotalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    private static final String PAGE_NAME = "budget";

    private final TotalsService totalsService;

    @Autowired
    public BudgetController(TotalsService budgetService) {
        this.totalsService = budgetService;
    }

    @ModelAttribute
    public void fillModel(Model model) {
        model.addAttribute("pageName", PAGE_NAME);
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("totals", totalsService.getTotalsForPeriod());
        return PAGE_NAME;
    }
}
