package com.example.Test.response;

import lombok.Data;

@Data
public class SizeProductResponse {
    private Long sizeId;
    private String size;

    public SizeProductResponse(Long sizeId, String size) {
        this.sizeId = sizeId;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }
}
