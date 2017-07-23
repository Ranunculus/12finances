package com.twelveweeks.controllers;

import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.domain.transactions.Expense;
import com.twelveweeks.domain.transactions.Finance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@Controller
public class TransactionsController {

    @RequestMapping("/")
    public String indexTest(Model model){
        Category category = new Category();
        category.setLimit(new BigDecimal(10));
        category.setName("Еда");
        Finance expense = new Expense();
        expense.setCategory(category);
        expense.setDate(new Date());
        expense.setValue(new BigDecimal(10000));
        model.addAttribute("rows", Collections.singletonList(expense));
        return "period";
    }

    @RequestMapping("/period")
    public String periodTransactions(@RequestParam Date startDate, @RequestParam Date endDate){

        return "period";
    }

}
