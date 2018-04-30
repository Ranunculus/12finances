package com.twelveweeks.controllers.request;

import com.twelveweeks.domain.enums.BudgetType;

import java.math.BigDecimal;

public class SettingsBudgetRequest {

    private BudgetType type;
    private BigDecimal amount;
    private int categoryId;

    public SettingsBudgetRequest() {
    }

    public SettingsBudgetRequest(BudgetType type, BigDecimal amount, int categoryId) {
        this.type = type;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public BudgetType getType() {
        return type;
    }

    public void setType(BudgetType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
