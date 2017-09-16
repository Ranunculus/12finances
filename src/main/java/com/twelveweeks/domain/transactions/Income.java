package com.twelveweeks.domain.transactions;



import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "INCOME")


public class Income extends Transaction {
    @Override
    public BigDecimal getValue() {
        return null;
    }

    @Override
    public void setValue(BigDecimal value) {

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public void setDate(Date date) {

    }

    @Override
    public Integer getUserId() {
        return null;
    }

    @Override
    public void setUserId(Integer userId) {

    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public void setCategory(Category category) {

    }
}
