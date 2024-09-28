package com.example.Test.request;

public class ColorProductRequest {
    private Long colorId;
    private String name;
    private Long productId;

    public ColorProductRequest(Long colorId, String name, Long productId) {
        this.colorId = colorId;
        this.name = name;
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
