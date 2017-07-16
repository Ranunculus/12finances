package com.twelveweeks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Expense implements Finance {

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private BigDecimal value;

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private Category category;

}
