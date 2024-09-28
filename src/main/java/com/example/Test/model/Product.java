package com.example.Test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    private String description;
    private Double productPrice;
    private Integer views;
    @Column(name = "discount_price")
    private Double discountPrice;
    @Column(name="expired_promotion")
    private LocalDateTime expiredPromotion;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories ;
    @ManyToMany
    @JoinTable(
            name = "product_style",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "style_id")
    )
    private List<StyleProduct> styleProducts;
    @ManyToMany
    @JoinTable(
            name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    private List<Size> sizes;
    @ManyToMany
    @JoinTable(
            name = "product_color",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<ColorProduct> colorProducts ;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageProduct> imageProducts;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Rate> rates;

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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<ImageProduct> getImageProducts() {
        return imageProducts;
    }

    public void setImageProducts(List<ImageProduct> imageProducts) {
        this.imageProducts = imageProducts;
    }

    public List<StyleProduct> getStyleProducts() {
        return styleProducts;
    }

    public void setStyleProducts(List<StyleProduct> styleProducts) {
        this.styleProducts = styleProducts;
    }

    public List<ColorProduct> getColorProducts() {
        return colorProducts;
    }

    public void setColorProducts(List<ColorProduct> colorProducts) {
        this.colorProducts = colorProducts;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
