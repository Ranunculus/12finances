package com.twelveweeks.domain.budget;

import java.math.BigDecimal;

public class Totals {
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
