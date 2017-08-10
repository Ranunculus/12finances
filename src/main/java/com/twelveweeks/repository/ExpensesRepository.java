package com.twelveweeks.repository;

import com.twelveweeks.domain.transactions.Expenses;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {

    Iterable<Expenses> findByDateBetween(Date startDate, Date endDate);
}
