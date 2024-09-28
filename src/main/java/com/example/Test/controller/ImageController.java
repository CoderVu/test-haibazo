package com.example.Test.controller;

import com.example.Test.request.ImageProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.IImageProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private final IImageProductService imageService;

    public ImageController(IImageProductService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addImage(@RequestParam("image") MultipartFile image, @RequestParam("productId") Long productId) {
        ImageProductRequest imageProductRequest = new ImageProductRequest(image, productId);
        return imageService.addImageProduct(imageProductRequest);
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getImagesByProductId(@PathVariable Long productId) {
        return imageService.getImagesByProductId(productId);
    }
}