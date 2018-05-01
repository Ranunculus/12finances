package com.twelveweeks.controllers.request;

import com.twelveweeks.domain.enums.TransactionType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ranunculus on 2/04/18.
 */
public class TransactionRequest {

    @NotNull
    @Min(0)
    private BigDecimal value;

    @NotNull
    private String category;

    @NotNull
    private TransactionType type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date date;

    public TransactionRequest() {
    }

    public TransactionRequest(BigDecimal value, String category, TransactionType type, Date date) {
        this.value = value;
        this.category = category;
        this.type = type;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
