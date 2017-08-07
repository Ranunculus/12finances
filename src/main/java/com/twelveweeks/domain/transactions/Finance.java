package com.twelveweeks.domain.transactions;

import java.math.BigDecimal;
import java.util.Date;

public interface Finance {

    BigDecimal getValue();
    void setValue(BigDecimal value);

    String getType();
    void setType(String type);

    Date getDate();
    void setDate(Date date);

    Integer getUserId();
    void setUserId(Integer userId);

    Category getCategory();
    void setCategory(Category category);

}
