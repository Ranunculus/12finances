package com.twelveweeks.controllers;

import com.twelveweeks.domain.enums.TransactionType;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    public CategoryRepository categoryRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "settings";
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestParam TransactionType transactionType,
                              @RequestParam String categoryName,
                              @RequestParam BigDecimal limit) {
        Category category = new Category();
        category.setLimit(limit);
        category.setName(categoryName);
        // TODO: 26/04/18
//        category.setTransactionType(transactionType);
        categoryRepository.save(category);
        return "redirect:/settings";
    }
}
