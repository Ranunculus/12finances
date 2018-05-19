package com.twelveweeks.controllers.settings;

import com.twelveweeks.domain.enums.TransactionType;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.repository.BudgetRepository;
import com.twelveweeks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/settings/category")
public class CategorySettingsController extends SettingsController {

    @Autowired
    public CategorySettingsController(CategoryRepository categoryRepository,
                                      BudgetRepository budgetRepository) {
        super(categoryRepository, budgetRepository);
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam TransactionType transactionType,
                              @RequestParam String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        category.setType(transactionType);
        categoryRepository.save(category);
        return "redirect:/settings";
    }

    @PostMapping("/remove")
    public String removeCategory(@RequestParam Integer id) {
        categoryRepository.deleteById(id);
        return "redirect:/settings";
    }
}
