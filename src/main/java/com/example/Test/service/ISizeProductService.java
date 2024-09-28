package com.example.Test.service;

import com.example.Test.request.SizeProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.SizeProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISizeProductService {
    ResponseEntity<APIResponse> addSize(SizeProductRequest sizeProductRequest);


    ResponseEntity<APIResponse> addSizeToProduct(Long productId, Long sizeId);

    ResponseEntity<APIResponse> getSizesByProductId(Long productId);
}
