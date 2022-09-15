package com.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.entities.Category;
import com.pharmacy.entities.CategoryEnum;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(CategoryEnum name);

}
