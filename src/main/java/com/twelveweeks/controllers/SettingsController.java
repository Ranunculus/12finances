package com.twelveweeks.controllers;

import com.twelveweeks.controllers.request.SettingsBudgetRequest;
import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.enums.TransactionType;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.repository.BudgetRepository;
import com.twelveweeks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private static final String PAGE_NAME = "settings";

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public BudgetRepository budgetRepository;

    @ModelAttribute
    public void fillModel(Model model) {
        model.addAttribute("pageName", PAGE_NAME);
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("budgets", budgetRepository.findAll());
        return "settings";
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestParam TransactionType transactionType,
                              @RequestParam String categoryName,
                              @RequestParam BigDecimal limit) {
        Category category = new Category();
        category.setLimit(limit);
        category.setName(categoryName);
        category.setType(transactionType);
        categoryRepository.save(category);
        return "redirect:/settings";
    }

    @PostMapping("/budget/set")
    public String setBudgets(SettingsBudgetRequest budget) {
        Budget budgetObject = new Budget(budget.getType(), budget.getAmount(), categoryRepository.findOne(budget.getCategoryId()));
        budgetRepository.save(budgetObject);
        return "redirect:/settings";
    }
}
