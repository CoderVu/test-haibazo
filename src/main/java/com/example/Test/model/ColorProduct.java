package com.example.Test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ColorProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_product_id")
    private Long colorProductId;
    private String color;
    @ManyToMany(mappedBy = "colorProducts")
    private List<Product> products;

    public Long getColorProductId() {
        return colorProductId;
    }

    public void setColorProductId(Long colorProductId) {
        this.colorProductId = colorProductId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
