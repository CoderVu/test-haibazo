package com.example.Test.request;

import java.time.LocalDateTime;


public class ProductRequest {
    private String productName;
    private String description;
    private Double productPrice;
    private Integer views;
    private Double price;
    private Double discountPrice;
    private LocalDateTime expiredPromotion;
    private Long categoryId;
    public void ProductRequest(String productName, String description, Double productPrice, Integer views, Double price, Double discountPrice, LocalDateTime expiredPromotion, Long categoryId) {
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.views = views;
        this.price = price;
        this.discountPrice = discountPrice;
        this.expiredPromotion = expiredPromotion;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public LocalDateTime getExpiredPromotion() {
        return expiredPromotion;
    }

    public void setExpiredPromotion(LocalDateTime expiredPromotion) {
        this.expiredPromotion = expiredPromotion;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
