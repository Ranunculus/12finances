package com.twelveweeks.controllers.form;

import java.math.BigDecimal;

/**
 * Created by Ranunculus on 2/04/18.
 */
public class TransactionForm {

    private BigDecimal value;

    // TODO: 2/04/18
    private String category;

    public TransactionForm() {
    }

    public TransactionForm(BigDecimal value, String category) {
        this.value = value;
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TransactionForm{" +
                "value=" + value +
                ", category='" + category + '\'' +
                '}';
    }
}
