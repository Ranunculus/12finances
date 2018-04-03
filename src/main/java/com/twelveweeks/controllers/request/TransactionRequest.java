package com.twelveweeks.controllers.request;

import com.twelveweeks.domain.enums.TransactionType;

import java.math.BigDecimal;

/**
 * Created by Ranunculus on 2/04/18.
 */
public class TransactionRequest {

    private BigDecimal value;

    private String category;

    private TransactionType type;

    public TransactionRequest() {
    }

    public TransactionRequest(BigDecimal value, String category, TransactionType type) {
        this.value = value;
        this.category = category;
        this.type = type;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "value=" + value +
                ", category='" + category + '\'' +
                ", type=" + type +
                '}';
    }
}
