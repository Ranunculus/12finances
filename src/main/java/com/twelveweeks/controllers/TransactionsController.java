package com.twelveweeks.controllers;

import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.domain.transactions.Expenses;
import com.twelveweeks.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@Controller
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @RequestMapping("/")
    public String indexTest(Model model){

        service.testDataSource();
        Category category = new Category();
        category.setLimit(new BigDecimal(10));
        category.setName("Еда");
        Expenses expense = new Expenses();
//        expense.setCategory(new );
//        expense.setDate(new Date());
//        expense.setValue(new BigDecimal(10000));
        model.addAttribute("rows", Collections.singletonList(expense));
        return "period";
    }

    @RequestMapping("/period")
    public String periodTransactions(@RequestParam Date startDate, @RequestParam Date endDate){

        return "period";
    }

}
