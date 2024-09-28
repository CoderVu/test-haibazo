package com.example.Test.service.Impl;

import com.example.Test.model.Category;
import com.example.Test.model.Product;
import com.example.Test.repository.CategoryRepository;
import com.example.Test.repository.ProductRepository;
import com.example.Test.request.CategoryRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.CategoryResponse;
import com.example.Test.response.ResponseConverter;
import com.example.Test.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addCategory(CategoryRequest categoryRequest) {
        if (categoryRepository.existsByCategoryName(categoryRequest.getName())) {
            return ResponseEntity.ok(new APIResponse(false, "Category already exists", ""));
        }
        Category category = new Category();
        category.setCategoryName(categoryRequest.getName());
        categoryRepository.save(category);
        return ResponseEntity.ok(new APIResponse(true, "Category added successfully", ""));
    }

    @Override
    public ResponseEntity<APIResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(ResponseConverter::convertToCategoryResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new APIResponse(true, "Categories fetched successfully", categoryResponses));
    }

    @Override
    public ResponseEntity<APIResponse> addCategoryToProduct(Long productId, Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Category not found", ""));
        }
        Category category = categoryOptional.get();
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        Product product = productOptional.get();
        List<Category> categories = product.getCategories();
        if (categories == null) {
            categories = new java.util.ArrayList<>();
        }
        if (categories.contains(category)) {
            return ResponseEntity.ok(new APIResponse(false, "Category already added to product", ""));
        }
        categories.add(category);
        product.setCategories(categories);
        productRepository.save(product);
        return ResponseEntity.ok(new APIResponse(true, "Category added to product successfully", ""));
    }

    @Override
    public ResponseEntity<APIResponse> getCategoriesByProductId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        Product product = productOptional.get();
        List<Category> categories = product.getCategories();
        if (categories == null) {
            return ResponseEntity.ok(new APIResponse(false, "No category found", ""));
        }
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(ResponseConverter::convertToCategoryResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse(true, "Categories fetched successfully", categoryResponses));
    }
}
