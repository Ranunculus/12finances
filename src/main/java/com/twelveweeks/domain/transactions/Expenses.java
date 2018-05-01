package com.twelveweeks.domain.transactions;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EXPENSE")
public class Expenses extends Transaction {}
