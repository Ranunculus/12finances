package com.twelveweeks.domain.transactions;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EXPENSES")
public class Expenses implements Finance {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "AMOUNT", precision = 6, scale = 2)
    private BigDecimal value;

    @Column(name = "EXPENSE_TYPE")
    private String type;

    @Column(name = "TRANSACTION_DATE")
    private Date date;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "CURRENCY")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Expenses() {
    }

    public Expenses(BigDecimal value, String type, Date date, Integer userId, String currency, Category category) {
        this.value = value;
        this.type = type;
        this.date = date;
        this.userId = userId;
        this.currency = currency;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
