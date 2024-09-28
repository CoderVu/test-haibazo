package com.example.Test.response;

import lombok.Data;

@Data
public class ImageProductResponse {
    private Long imageProductId;
    private String image;
    public ImageProductResponse(Long imageProductId, String image) {
        this.imageProductId = imageProductId;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getImageProductId() {
        return imageProductId;
    }

    public void setImageProductId(Long imageProductId) {
        this.imageProductId = imageProductId;
    }
}
