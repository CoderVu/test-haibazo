package com.example.Test.repository;

import com.example.Test.model.ColorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorProductRepository extends JpaRepository<ColorProduct, Long> {
    boolean existsByColor(String color);
    @Query("SELECT cp FROM ColorProduct cp JOIN cp.products p WHERE p.productId = :productId")
    List<ColorProduct> findByProductId(Long productId);
}
