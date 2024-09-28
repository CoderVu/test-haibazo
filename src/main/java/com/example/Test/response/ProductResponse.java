package com.example.Test.response;

import com.example.Test.model.ImageProduct;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponse {
    private Long productId;
    private String productName;
    private String description;
    private Double productPrice;
    private Integer views;
    private Double averageRate;
    private Double discountPrice;
    private LocalDateTime expiredPromotion;
    private List<CategoryResponse> categories;
    List<ImageProductResponse> images;
    List<ColorProductResponse> colors;
    List<SizeProductResponse> sizes;
    List<StyleProductResponse> styles;
    List<RateProductResponse> rates;

    public ProductResponse(Long productId, String productName, String description, Double productPrice, Integer views, Double averageRate, Double discountPrice,LocalDateTime expiredPromotion, List<CategoryResponse> categories, List<ImageProductResponse> images, List<ColorProductResponse> colors, List<SizeProductResponse> sizes, List<StyleProductResponse> styles, List<RateProductResponse> rates) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.views = views;
        this.averageRate = averageRate;
        this.discountPrice = discountPrice;
        this.expiredPromotion = expiredPromotion;
        this.categories = categories;
        this.images = images;
        this.colors = colors;
        this.sizes = sizes;
        this.styles = styles;
        this.rates = rates;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public List<CategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    public List<ImageProductResponse> getImages() {
        return images;
    }

    public void setImages(List<ImageProductResponse> images) {
        this.images = images;
    }

    public List<ColorProductResponse> getColors() {
        return colors;
    }

    public void setColors(List<ColorProductResponse> colors) {
        this.colors = colors;
    }

    public List<SizeProductResponse> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeProductResponse> sizes) {
        this.sizes = sizes;
    }

    public List<StyleProductResponse> getStyles() {
        return styles;
    }

    public void setStyles(List<StyleProductResponse> styles) {
        this.styles = styles;
    }
    public List<RateProductResponse> getRates() {
        return rates;
    }
    public void setRates(List<RateProductResponse> rates) {
        this.rates = rates;
    }
    public Double getAverageRate() {
        return averageRate;
    }
    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }
}

