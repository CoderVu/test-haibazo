package com.example.Test.service;

import com.example.Test.model.Category;
import com.example.Test.request.CategoryRequest;
import com.example.Test.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    ResponseEntity<APIResponse> addCategory(CategoryRequest categoryRequest);

    ResponseEntity<APIResponse> getCategories();

    ResponseEntity<APIResponse> addCategoryToProduct(Long productId, Long categoryId);

    ResponseEntity<APIResponse> getCategoriesByProductId(Long productId);
}
