package com.example.Test.request;


import lombok.Data;
import lombok.NoArgsConstructor;


public class SizeProductRequest {
    private Long sizeId;
    private String size;
    private Long productId;

    public SizeProductRequest(Long sizeId, String size, Long productId) {
        this.sizeId = sizeId;
        this.size = size;
        this.productId = productId;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
