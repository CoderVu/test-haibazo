package com.example.Test.response;

import lombok.Data;

import java.util.List;

@Data
public class ColorProductResponse {
    private Long colorProductId;
    private String color;

    public ColorProductResponse(Long colorProductId, String color) {
        this.colorProductId = colorProductId;
        this.color = color;
    }

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
}
