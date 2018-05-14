package com.twelveweeks.controllers;

import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.domain.transactions.Expenses;
import com.twelveweeks.repository.BudgetRepository;
import com.twelveweeks.repository.CategoryRepository;
import com.twelveweeks.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    private static final String PAGE_NAME = "budget";

    private final CategoryRepository categoryRepository;
    private final ExpensesRepository expensesRepository;
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetController(CategoryRepository categoryRepository,
                            ExpensesRepository expensesRepository,
                            BudgetRepository budgetRepository) {
        this.categoryRepository = categoryRepository;
        this.expensesRepository = expensesRepository;
        this.budgetRepository = budgetRepository;
    }

    @ModelAttribute
    public void fillModel(Model model) {
        model.addAttribute("pageName", PAGE_NAME);
    }

    @GetMapping
    public String index() {

        Iterable<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            Iterable<Expenses> expenses = expensesRepository.findByCategory(category);
            BigDecimal total = BigDecimal.ZERO;
            for (Expenses expense : expenses) {
                total = total.add(expense.getValue());
            }
            Budget budget = budgetRepository.findByCategory(category);
            if (budget != null) {
                System.out.println(budget.getAmount().subtract(total));
            }
        }
        return "budget";
    }

}
