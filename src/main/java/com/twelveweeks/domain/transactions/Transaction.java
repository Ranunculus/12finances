package com.twelveweeks.domain.transactions;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class Transaction implements Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "AMOUNT", precision = 10, scale = 2)
    private BigDecimal value;

    @Column(name = "TRANSACTION_TYPE")
    private String type;

    @Column(name = "TRANSACTION_DATE")
    private Date date;

    @Column(name = "USER_ID")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    protected Category category;

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                ", category=" + category +
                '}';
    }
}
