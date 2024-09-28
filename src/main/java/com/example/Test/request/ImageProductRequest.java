package com.example.Test.request;

import org.springframework.web.multipart.MultipartFile;

public class ImageProductRequest {
    private MultipartFile image;
    private Long productId;

    public ImageProductRequest(MultipartFile image, Long productId) {
        this.image = image;
        this.productId = productId;
    }

    public void ImageProductRequest(MultipartFile image, Long productId) {
        this.image = image;
        this.productId = productId;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
