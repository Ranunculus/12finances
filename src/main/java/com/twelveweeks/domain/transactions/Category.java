package com.twelveweeks.domain.transactions;

import com.twelveweeks.domain.enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @Column(name = "CATEGORY_LIMIT")
    private BigDecimal limit;

    @Column(name = "TRANSACTION_TYPE")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Category() {
    }

    public Category(String name, BigDecimal limit) {
        this.name = name;
        this.limit = limit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                '}';
    }
}
