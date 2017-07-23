package com.twelveweeks.domain.transactions;

import java.math.BigDecimal;

public class Category {
    private String name;
    private BigDecimal limit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
