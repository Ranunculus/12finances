package com.twelveweeks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class TransactionsController {

    @RequestMapping("/period")
    public String periodTransactions(@RequestParam Date startDate, @RequestParam Date endDate){

        return "period";
    }

}
