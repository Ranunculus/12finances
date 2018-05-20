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
import java.util.ArrayList;
import java.util.List;

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
    public String index(Model model) {

        List<Totals> totals = new ArrayList<>();
        Iterable<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            Totals categoryTotal = new Totals(category.getName());
            Iterable<Expenses> expenses = expensesRepository.findByCategory(category);
            BigDecimal total = BigDecimal.ZERO;
            for (Expenses expense : expenses) {
                total = total.add(expense.getValue());
            }
            categoryTotal.setSpent(total);
            Budget budget = budgetRepository.findByCategory(category);
            if (budget != null) {
                categoryTotal.setLimit(budget.getAmount());
                categoryTotal.setLeft(budget.getAmount().subtract(total));
            }
            totals.add(categoryTotal);

        }
        model.addAttribute("totals", totals);
        return PAGE_NAME;
    }

    // TODO: 20/05/18 separate class
    private class Totals {
        private String categoryName;
        private BigDecimal limit;
        private BigDecimal spent;
        private BigDecimal left;

        public Totals(String categoryName) {
            this.categoryName = categoryName;
        }

        public Totals(String categoryName, BigDecimal limit, BigDecimal spent, BigDecimal left) {
            this.categoryName = categoryName;
            this.limit = limit;
            this.spent = spent;
            this.left = left;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public BigDecimal getLimit() {
            return limit;
        }

        public void setLimit(BigDecimal limit) {
            this.limit = limit;
        }

        public BigDecimal getSpent() {
            return spent;
        }

        public void setSpent(BigDecimal spent) {
            this.spent = spent;
        }

        public BigDecimal getLeft() {
            return left;
        }

        public void setLeft(BigDecimal left) {
            this.left = left;
        }
    }

}
