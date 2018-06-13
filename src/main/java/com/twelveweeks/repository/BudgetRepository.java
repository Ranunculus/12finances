package com.twelveweeks.repository;

import com.twelveweeks.domain.budget.Budget;
import com.twelveweeks.domain.enums.BudgetType;
import com.twelveweeks.domain.transactions.Category;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Integer> {

    Budget findByCategory(Category category);
    Budget findByTypeAndCategory(BudgetType type, Category category);
}
