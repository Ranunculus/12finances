package com.twelveweeks.domain.transactions;



import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EXPENSE")
public class Expenses extends Transaction {}
