package com.example.Test.service;

import com.example.Test.request.RateRequest;
import com.example.Test.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface IRatingService {

    ResponseEntity<APIResponse> addRating(RateRequest rateRequest);

    ResponseEntity<APIResponse> getRatingsByProductId(Long productId);
}
