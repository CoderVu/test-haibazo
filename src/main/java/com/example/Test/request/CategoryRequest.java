package com.example.Test.request;

public class CategoryRequest {
    private Long categoryId;
    private String name;
    private Long productId;

    public CategoryRequest(Long categoryId, String name, Long productId) {
        this.categoryId = categoryId;
        this.name = name;
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}