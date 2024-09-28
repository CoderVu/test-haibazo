package com.example.Test.controller;

import com.example.Test.request.CategoryRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.addCategory(categoryRequest);
    }

    @GetMapping("/get/all")
    public ResponseEntity<APIResponse> getCategories() {
        return categoryService.getCategories();
    }
    @PostMapping("/add/product")
    public ResponseEntity<APIResponse> addCategoryToProduct(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.addCategoryToProduct(categoryRequest.getProductId(), categoryRequest.getCategoryId());
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<APIResponse> getCategoriesByProductId(@PathVariable Long productId) {
        return categoryService.getCategoriesByProductId(productId);
    }
}
