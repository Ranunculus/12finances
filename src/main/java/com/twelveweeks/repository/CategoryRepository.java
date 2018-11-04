package com.twelveweeks.repository;

import com.twelveweeks.domain.enums.TransactionType;
import com.twelveweeks.domain.transactions.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findOneByName(String name);

    List<Category> findByType(TransactionType type);

}
