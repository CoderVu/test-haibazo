package com.example.Test.response;

import lombok.Data;

@Data
public class RateProductResponse {
    private Long rateProductId;
    private int rate;
    private String comment;

    public RateProductResponse(Long rateProductId, int rate, String comment) {
        this.rateProductId = rateProductId;
        this.rate = rate;
        this.comment = comment;
    }

    public Long getRateProductId() {
        return rateProductId;
    }

    public void setRateProductId(Long rateProductId) {
        this.rateProductId = rateProductId;
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
}
