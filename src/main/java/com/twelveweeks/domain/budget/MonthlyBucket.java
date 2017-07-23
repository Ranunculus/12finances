package com.twelveweeks.domain.budget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyBucket{
    private String name;
    private BigDecimal limit;
}
