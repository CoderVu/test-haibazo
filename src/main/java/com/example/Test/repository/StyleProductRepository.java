package com.example.Test.repository;

import com.example.Test.model.StyleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StyleProductRepository extends JpaRepository<StyleProduct, Long> {
    @Query("SELECT sp FROM StyleProduct sp JOIN sp.products p WHERE p.productId = :productId")
    List<StyleProduct> findByProductId(@Param("productId") Long productId);
}
