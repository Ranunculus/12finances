package com.twelveweeks.repository;

import com.twelveweeks.domain.transactions.Income;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

    Iterable<Income> findByDateBetween(Date startDate, Date endDate);

}
