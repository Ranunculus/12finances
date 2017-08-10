package com.twelveweeks.domain.transactions;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EXPENSE")

@Log
@AllArgsConstructor
@ToString
public class Expenses extends Transaction {
}
