package com.twelveweeks.controllers.settings;

import com.twelveweeks.repository.BudgetRepository;
import com.twelveweeks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private static final String PAGE_NAME = "settings";

    final CategoryRepository categoryRepository;
    final BudgetRepository budgetRepository;

    @Autowired
    public SettingsController(CategoryRepository categoryRepository,
                              BudgetRepository budgetRepository) {
        this.categoryRepository = categoryRepository;
        this.budgetRepository = budgetRepository;
    }

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
}
