package com.twelveweeks.service;

import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.budget.Totals;
import com.twelveweeks.domain.enums.TransactionType;
import com.twelveweeks.domain.transactions.Category;
import com.twelveweeks.domain.transactions.Expenses;
import com.twelveweeks.repository.CategoryRepository;
import com.twelveweeks.repository.ExpensesRepository;
import com.twelveweeks.service.budget.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TotalsService {

    private final BudgetService budgetService;
    private final CategoryRepository categoryRepository;
    private final ExpensesRepository expensesRepository;

    @Autowired
    public TotalsService(BudgetService budgetService,
                         CategoryRepository categoryRepository,
                         ExpensesRepository expensesRepository) {
        this.budgetService = budgetService;
        this.categoryRepository = categoryRepository;
        this.expensesRepository = expensesRepository;
    }

    // TODO: 5/11/18 calculate by period
    public List<Totals> getTotalsForPeriod() {
        List<Totals> totals = new ArrayList<>();
        Iterable<Category> all = categoryRepository.findByType(TransactionType.EXPENSE);
        for (Category category : all) {
            Totals categoryTotal = new Totals(category.getName());
            Iterable<Expenses> expenses = expensesRepository.findByCategory(category);
            BigDecimal total = BigDecimal.ZERO;
            for (Expenses expense : expenses) {
                total = total.add(expense.getValue());
            }
            categoryTotal.setSpent(total);
            Budget budget = budgetService.findByCategory(category);
            if (budget != null) {
                categoryTotal.setLimit(budget.getAmount());
                categoryTotal.setLeft(budget.getAmount().subtract(total));
            }
            totals.add(categoryTotal);

        }
        return totals;
    }

}
