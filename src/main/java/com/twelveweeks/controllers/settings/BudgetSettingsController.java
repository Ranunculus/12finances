package com.twelveweeks.controllers.settings;

import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.enums.BudgetType;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.repository.BudgetRepository;
import com.twelveweeks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/settings/budget")
public class BudgetSettingsController extends SettingsController {

    @Autowired
    public BudgetSettingsController(CategoryRepository categoryRepository,
                                    BudgetRepository budgetRepository) {
        super(categoryRepository, budgetRepository);
    }

    @PostMapping("/set")
    public String setBudgets(@RequestParam BudgetType type,
                             @RequestParam BigDecimal amount,
                             @RequestParam Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        Budget currentBudget = budgetRepository.findByTypeAndCategory(type, category);
        if (currentBudget == null) {
            Budget budgetObject = new Budget(type, amount, category);
            budgetRepository.save(budgetObject);
        } else {
            // TODO: 13/06/18 throw an error
        }
        return "redirect:/settings";
    }

    @PostMapping("/remove")
    public String removeCategory(@RequestParam Integer id) {
        budgetRepository.deleteById(id);
        return "redirect:/settings";
    }
}
