package com.example.Test.controller;

import com.example.Test.request.SizeProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.ISizeProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/size")
public class SizeController {
    private final ISizeProductService sizeProductService;

    public SizeController(ISizeProductService sizeProductService) {
        this.sizeProductService = sizeProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addSize(@RequestBody SizeProductRequest sizeRequest) {
     return sizeProductService.addSize(sizeRequest);
    }
    @PostMapping("/add/product")
    public ResponseEntity<APIResponse> addSizeToProduct(@RequestBody SizeProductRequest sizeRequest) {
        return sizeProductService.addSizeToProduct(sizeRequest.getProductId(), sizeRequest.getSizeId());
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getSizesByProductId(@PathVariable Long productId) {
        return sizeProductService.getSizesByProductId(productId);
    }
}
