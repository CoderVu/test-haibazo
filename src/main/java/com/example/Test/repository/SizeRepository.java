package com.example.Test.repository;

import com.example.Test.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size, Long> {
    @Query("SELECT s FROM Size s JOIN s.products p WHERE p.productId = :productId")
    List<Size> findByProductId(Long productId);
}
