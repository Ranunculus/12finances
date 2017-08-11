package com.twelveweeks.repository;

import com.twelveweeks.domain.transactions.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Category findOneByName(String name);

}
