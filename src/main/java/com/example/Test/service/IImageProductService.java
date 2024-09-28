package com.example.Test.service;

import com.example.Test.request.ImageProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.ImageProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IImageProductService {
    ResponseEntity<APIResponse> addImageProduct(ImageProductRequest imageProductRequest);

    ResponseEntity<APIResponse> getImagesByProductId(Long productId);
}
