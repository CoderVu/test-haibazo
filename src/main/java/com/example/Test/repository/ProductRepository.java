package com.example.Test.repository;

import com.example.Test.model.Product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    boolean existsByProductName(String name);

    Product findByProductName(String productName);
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Product p JOIN p.categories c " +
            "WHERE p.productName = :productName AND c.categoryId = :categoryId")
    boolean existsByProductNameAndCategoryId(String productName, Long categoryId);
    @Query("SELECT p FROM Product p WHERE p.productPrice BETWEEN :minPrice AND :maxPrice ORDER BY p.productPrice ASC")
    List<Product> findProductsByPriceRangeAsc(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    @Query("SELECT p FROM Product p WHERE p.productPrice BETWEEN :minPrice AND :maxPrice ORDER BY p.productPrice DESC")
    List<Product> findProductsByPriceRangeDesc(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN p.categories c " +
            "LEFT JOIN p.colorProducts cp " +
            "LEFT JOIN p.sizes s " +
            "LEFT JOIN p.styleProducts sp " +
            "WHERE (:categoryId IS NULL OR c.categoryId = :categoryId) " +
            "AND (:colorId IS NULL OR cp.colorProductId = :colorId) " +
            "AND (:sizeId IS NULL OR s.sizeId = :sizeId) " +
            "AND (:styleId IS NULL OR sp.styleProductId = :styleId) " +
            "AND (:minPrice IS NULL OR p.productPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.productPrice <= :maxPrice) " +
            "AND (:minPrice IS NOT NULL OR :maxPrice IS NOT NULL OR (p.productPrice IS NOT NULL))")
    List<Product> findProductsByMultipleFilters(
            @Param("categoryId") Long categoryId,
            @Param("colorId") Long colorId,
            @Param("sizeId") Long sizeId,
            @Param("styleId") Long styleId,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice);


}
