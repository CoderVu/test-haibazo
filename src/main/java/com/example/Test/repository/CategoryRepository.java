package com.example.Test.repository;

import com.example.Test.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String name);
    boolean existsByCategoryName(String name);
}
