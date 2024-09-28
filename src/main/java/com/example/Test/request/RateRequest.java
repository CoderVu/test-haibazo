package com.example.Test.request;


public class RateRequest {
    private int rate;
    private String comment;
    private Long productId;
    public void RateRequest(int rate, String comment, Long productId) {
        this.rate = rate;
        this.comment = comment;
        this.productId = productId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
