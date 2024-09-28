package com.example.Test.request;

import lombok.Data;

public class StyleRequest {
    private String name;
    private Long productId;
    private Long styleId;
    public void StyleRequest(String name, Long productId, Long styleId) {
        this.name = name;
        this.productId = productId;
        this.styleId = styleId;
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

    public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }
}
