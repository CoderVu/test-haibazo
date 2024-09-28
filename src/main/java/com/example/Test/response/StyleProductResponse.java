package com.example.Test.response;

import lombok.Data;

@Data
public class StyleProductResponse {
    private Long styleProductId;
    private String style;

    public StyleProductResponse(Long styleProductId, String style) {
        this.styleProductId = styleProductId;
        this.style = style;
    }

    public Long getStyleProductId() {
        return styleProductId;
    }

    public void setStyleProductId(Long styleProductId) {
        this.styleProductId = styleProductId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
