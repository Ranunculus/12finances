package com.twelveweeks.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ranunculus on 16/07/17.
 */
public interface Finance {

    BigDecimal getValue();

    String getType();

    Date getDate();

    Long getUserId();

    Category getCategory();

}
