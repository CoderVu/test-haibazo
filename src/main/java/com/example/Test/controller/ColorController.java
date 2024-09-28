package com.example.Test.controller;

import com.example.Test.request.ColorProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.IColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/color")
public class ColorController {
    private final IColorService colorService;

    public ColorController(IColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addColor(@RequestBody ColorProductRequest colorProductRequest) {
        return colorService.addColor(colorProductRequest);
    }
    @PostMapping("/add/product")
    public ResponseEntity<APIResponse> addColorToProduct(@RequestBody ColorProductRequest colorProductRequest) {
        return colorService.addColorToProduct(colorProductRequest.getProductId(), colorProductRequest.getColorId());
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getColorsByProductId(@PathVariable Long productId) {
        return colorService.getColorsByProductId(productId);
    }


}
