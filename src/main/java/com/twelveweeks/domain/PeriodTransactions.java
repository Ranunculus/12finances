package com.twelveweeks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodTransactions {

    private Date startDate;
    private Date endDate;
    private Income income;
    private Expense expense;
}
