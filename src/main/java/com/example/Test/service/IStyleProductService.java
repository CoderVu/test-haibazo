package com.example.Test.service;

import com.example.Test.request.StyleRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.StyleProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStyleProductService {
    ResponseEntity<APIResponse> addStyle(StyleRequest styleRequest);


    ResponseEntity<APIResponse> addStyleToProduct(Long productId, Long styleId);

    ResponseEntity<APIResponse> getStylesByProductId(Long productId);
}
