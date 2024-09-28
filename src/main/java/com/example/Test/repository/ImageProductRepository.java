package com.example.Test.repository;

import com.example.Test.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageProductRepository  extends JpaRepository<ImageProduct, Long> {
    @Query("SELECT i FROM ImageProduct i WHERE i.product.productId = ?1")
    List<ImageProduct> findByProductId(Long productId);
}
