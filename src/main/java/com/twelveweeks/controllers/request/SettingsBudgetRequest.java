package com.twelveweeks.controllers.request;

import com.twelveweeks.domain.enums.BudgetType;

import java.math.BigDecimal;

public class SettingsBudgetRequest {

    private BudgetType period;
    private BigDecimal amount;
    private String name;

    public SettingsBudgetRequest(BudgetType period, BigDecimal amount, String name) {
        this.period = period;
        this.amount = amount;
        this.name = name;
    }

    public BudgetType getPeriod() {
        return period;
    }

    public void setPeriod(BudgetType period) {
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
