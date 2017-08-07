package com.twelveweeks.domain.transactions;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Expenses> expenses;

    public Category() {}

    public Category(String name, BigDecimal limit, List<Expenses> expenses) {
        this.name = name;
        this.limit = limit;
        this.expenses = expenses;
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

    public List<Expenses> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expenses> expenses) {
        this.expenses = expenses;
    }
}
