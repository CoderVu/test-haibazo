package com.example.Test.service;

import com.example.Test.request.ColorProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.ColorProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IColorService {
    ResponseEntity<APIResponse> addColor(ColorProductRequest colorProductRequest);

    ResponseEntity<APIResponse> addColorToProduct(Long productId, Long colorId);

    ResponseEntity<APIResponse> getColorsByProductId(Long productId);
}
