package com.example.Test.controller;

import com.example.Test.request.StyleRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.IStyleProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/style")
public class StyleController {
    private final IStyleProductService styleProductService;

    public StyleController(IStyleProductService styleProductService) {
        this.styleProductService = styleProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addStyle(@RequestBody StyleRequest styleRequest) {
        return styleProductService.addStyle(styleRequest);
    }
    @PostMapping("/add/product")
    public ResponseEntity<APIResponse> addStyleToProduct(@RequestBody StyleRequest styleRequest) {
        return styleProductService.addStyleToProduct(styleRequest.getProductId(), styleRequest.getStyleId());
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getStylesByProductId(@PathVariable Long productId) {
        return styleProductService.getStylesByProductId(productId);
    }

}
