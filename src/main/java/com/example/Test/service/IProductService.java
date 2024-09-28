package com.example.Test.service;

import com.example.Test.request.ProductRequest;
import com.example.Test.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<APIResponse> addProduct(ProductRequest productRequest);

    ResponseEntity<APIResponse> increaseViews(Long productId);

    ResponseEntity<APIResponse> getProducts();

    ResponseEntity<APIResponse> getProductById(Long productId);

    ResponseEntity<APIResponse> getProductsByCategory(Long categoryId);

    ResponseEntity<APIResponse> getProductsByColor(Long colorId);

    ResponseEntity<APIResponse> getProductsBySize(Long sizeId);

    ResponseEntity<APIResponse> getProductsByPriceRangeAsc(Double minPrice, Double maxPrice);

    ResponseEntity<APIResponse> getProductsByPriceRangeDesc(Double minPrice, Double maxPrice);

    ResponseEntity<APIResponse> getProductsByStyle(Long styleId);

    ResponseEntity<APIResponse> getProductsByMultipleFilters(Long categoryId, Long colorId, Long sizeId, Long styleId, Double minPrice, Double maxPrice);
}
