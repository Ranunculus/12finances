package com.twelveweeks.domain.budget;

import com.twelveweeks.domain.enums.BudgetType;
import com.twelveweeks.domain.transactions.Category;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BUDGET", uniqueConstraints = @UniqueConstraint(columnNames = {"BUDGET_TYPE", "CATEGORY_ID"}))
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "BUDGET_TYPE")
    @Enumerated(EnumType.STRING)
    private BudgetType type;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    protected Category category;

    public Budget() {
    }

    public Budget(BudgetType type, BigDecimal amount, Category category) {
        this.type = type;
        this.amount = amount;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", category=" + category +
                '}';
    }
}
