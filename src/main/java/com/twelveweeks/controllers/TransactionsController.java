package com.twelveweeks.controllers;

import com.twelveweeks.controllers.request.TransactionRequest;
import com.twelveweeks.domain.transactions.Expenses;
import com.twelveweeks.domain.transactions.Income;
import com.twelveweeks.domain.transactions.Transaction;
import com.twelveweeks.repository.CategoryRepository;
import com.twelveweeks.repository.ExpensesRepository;
import com.twelveweeks.repository.IncomeRepository;
import com.twelveweeks.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/now")
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
        model.addAttribute("transactionRequest", new TransactionRequest());

        model.addAttribute("categories", categoryRepository.findAll());
        return "period";
    }

    @RequestMapping("/period")
    public String periodTransactions(Model model,
                                     @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                     @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){

        ArrayList<Expenses> expenses = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (Expenses expense : expensesRepository.findByDateBetween(startDate, endDate)) {
            total = total.add(expense.getValue());
            expenses.add(expense);
        }
        model.addAttribute("expenseRows", expenses);
        model.addAttribute("expenseTotal", total);

        total = BigDecimal.ZERO;
        ArrayList<Income> incomes = new ArrayList<>();
        for (Income income : incomeRepository.findByDateBetween(startDate, endDate)) {
            total = total.add(income.getValue());
            incomes.add(income);
        }
        model.addAttribute("incomeRows", incomes);
        model.addAttribute("incomeTotal", total);
        model.addAttribute("transactionForm", new TransactionRequest());
        return "period";
    }

    @GetMapping("/add")
    public String indexTest(Model model, @Valid @ModelAttribute("transactionRequest") TransactionRequest transactionRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("transactionForm", transactionRequest);
            return "period";
        }

//        boolean isExpense = "Expense".equals(transactionType);
        Transaction transaction = new Expenses();

        transaction.setCurrency("RUB");

        transaction.setDate(new Date());
        transaction.setType(transactionRequest.getType().name());
        transaction.setUserId(1);
        transaction.setValue(transactionRequest.getValue());
        transaction.setCategory(categoryRepository.findOneByName(transactionRequest.getCategory()));
//        Category categoryByName = categoryRepository.findOneByName(categoryName);
//        transaction.setCategory(categoryByName);
//        if (isExpense) {
            expensesRepository.save((Expenses) transaction);
//        } else {
//            incomeRepository.save((Income) transaction);
//        }
        return "redirect:/";
    }

}
