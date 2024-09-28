package com.example.Test.controller;

import com.example.Test.request.RateRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.IProductService;
import com.example.Test.service.IRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rate")
public class RateController {
    private final IRatingService ratingService;
    private final IProductService productService;

    public RateController(IRatingService ratingService, IProductService productService) {
        this.ratingService = ratingService;
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addRating(@RequestBody RateRequest rateRequest) {
        return ratingService.addRating(rateRequest);
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getRatingsByProductId(@PathVariable Long productId) {
        return ratingService.getRatingsByProductId(productId);
    }


}
