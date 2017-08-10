package com.twelveweeks.controllers;

import com.twelveweeks.domain.transactions.Expenses;
import com.twelveweeks.domain.transactions.Income;
import com.twelveweeks.repository.ExpensesRepository;
import com.twelveweeks.repository.IncomeRepository;
import com.twelveweeks.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class TransactionsController {

    @Autowired
    TransactionsService service;

    @Autowired
    ExpensesRepository expensesRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @RequestMapping("/")
    public String indexTest(Model model){

        ArrayList<Expenses> expenses = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (Expenses expense : expensesRepository.findAll()) {
            total = total.add(expense.getValue());
            expenses.add(expense);
        }
        model.addAttribute("expenseRows", expenses);
        model.addAttribute("expenseTotal", total);

        ArrayList<Income> incomes = new ArrayList<>();
        total = BigDecimal.ZERO;
        for (Income income : incomeRepository.findAll()) {
            total = total.add(income.getValue());
            incomes.add(income);
        }
        model.addAttribute("incomeRows", incomes);
        model.addAttribute("incomeTotal", total);
        return "period";
    }

    @RequestMapping("/period")
    public String periodTransactions(Model model, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){

        ArrayList<Expenses> expenses = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (Expenses expense : expensesRepository.findByDateBetween(startDate, endDate)) {
            total = total.add(expense.getValue());
            expenses.add(expense);
        }
        model.addAttribute("rows", expenses);
        model.addAttribute("total", total);
        return "period";
    }

}
