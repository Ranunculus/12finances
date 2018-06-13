package com.twelveweeks.controllers.settings;

import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.enums.BudgetType;
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
        Budget budgetObject = new Budget(type, amount, categoryRepository.findById(categoryId).orElse(null));
        budgetRepository.save(budgetObject);
        return "redirect:/settings";
    }

    @PostMapping("/remove")
    public String removeCategory(@RequestParam Integer id) {
        budgetRepository.deleteById(id);
        return "redirect:/settings";
    }
}
