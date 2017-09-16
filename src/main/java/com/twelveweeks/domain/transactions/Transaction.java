package com.twelveweeks.domain.transactions;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public abstract class Transaction implements Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", unique = true, nullable = false)
    protected Integer id;

    @Column(name = "AMOUNT", precision = 10, scale = 2)
    protected BigDecimal value;

    @Column(name = "TRANSACTION_TYPE")
    protected String type;

    @Column(name = "TRANSACTION_DATE")
    protected Date date;

    @Column(name = "USER_ID")
    protected Integer userId;

    @Column(name = "CURRENCY")
    protected String currency;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    protected Category category;

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
