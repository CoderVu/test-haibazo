package com.example.Test.repository;

import com.example.Test.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query("SELECT r FROM Rate r WHERE r.product.productId = ?1")
    List<Rate> findByProductId(Long productId);
}
