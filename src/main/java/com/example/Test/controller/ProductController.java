package com.example.Test.controller;

import com.example.Test.request.ProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }
    @PostMapping("/increase/views/{productId}")
    public ResponseEntity<APIResponse> increaseViews(@PathVariable Long productId) {
        return productService.increaseViews(productId);
    }
    @GetMapping("/all")
    public ResponseEntity<APIResponse> getProducts() {
        return productService.getProducts();
    }
    @GetMapping("/{productId}")
    public ResponseEntity<APIResponse> getProduct(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
    @GetMapping("/filter/category/{categoryId}")
    public ResponseEntity<APIResponse> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
    @GetMapping("filter/color/{colorId}")
    public ResponseEntity<APIResponse> getProductsByColor(@PathVariable Long colorId) {
        return productService.getProductsByColor(colorId);
    }
    @GetMapping("filter/size/{sizeId}")
    public ResponseEntity<APIResponse> getProductsBySize(@PathVariable Long sizeId) {
        return productService.getProductsBySize(sizeId);
    }
    @GetMapping("/filter/price/asc")
    public ResponseEntity<APIResponse> getProductsByPriceRangeAsc(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.getProductsByPriceRangeAsc(minPrice, maxPrice);
    }

    @GetMapping("/filter/price/desc")
    public ResponseEntity<APIResponse> getProductsByPriceRangeDesc(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.getProductsByPriceRangeDesc(minPrice, maxPrice);
    }
    @GetMapping("/filter/style/{styleId}")
    public ResponseEntity<APIResponse> getProductsByStyle(@PathVariable Long styleId) {
        return productService.getProductsByStyle(styleId);
    }

    @GetMapping("/filter")
    public ResponseEntity<APIResponse> getProductsByMultipleFilters(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long colorId,
            @RequestParam(required = false) Long sizeId,
            @RequestParam(required = false) Long styleId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return productService.getProductsByMultipleFilters(categoryId, colorId, sizeId, styleId, minPrice, maxPrice);
    }


}
