package com.twelveweeks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class TransactionsService {

    DataSource dataSource;

    @Autowired
    public TransactionsService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void testDataSource(){
        try {
            System.out.println(dataSource.getConnection().getSchema());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
