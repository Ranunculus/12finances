package com.twelveweeks.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Income implements Finance{

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
