package com.example.Test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class StyleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "style_product_id")
    private Long styleProductId;
    private String style;
    @ManyToMany(mappedBy = "styleProducts")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Long getStyleProductId() {
        return styleProductId;
    }

    public void setStyleProductId(Long styleProductId) {
        this.styleProductId = styleProductId;
    }
}
