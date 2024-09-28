package com.example.Test.service.Impl;

import com.example.Test.model.*;
import com.example.Test.repository.*;
import com.example.Test.request.ProductRequest;
import com.example.Test.response.*;
import com.example.Test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductServiceImpl implements IProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final ColorProductRepository colorRepository;
    @Autowired
    private final SizeRepository sizeRepository;
    @Autowired
    private final StyleProductRepository styleRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ColorProductRepository colorRepository, SizeRepository sizeRepository, StyleProductRepository styleRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.colorRepository = colorRepository;
        this.sizeRepository = sizeRepository;
        this.styleRepository = styleRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addProduct(ProductRequest productRequest) {
        if (productRepository.existsByProductNameAndCategoryId(
                productRequest.getProductName(),
                productRequest.getCategoryId())){
            return ResponseEntity.ok(new APIResponse(false, "Product with the same name and attributes already exists", ""));
        }
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setProductPrice(productRequest.getProductPrice());
        product.setDiscountPrice(productRequest.getDiscountPrice());
        product.setExpiredPromotion(productRequest.getExpiredPromotion());
        productRepository.save(product);
        return ResponseEntity.ok(new APIResponse(true, "Add to product successfully", ""));

    }
    @Override
    public ResponseEntity<APIResponse> increaseViews(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Product not found", ""), HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        Integer currentViews = product.getViews();
        if (currentViews == null) {
            currentViews = 0;
        }
        product.setViews(currentViews + 1);
        productRepository.save(product);
        return ResponseEntity.ok(new APIResponse(true, "Increase views successfully", ""));
    }
    
    @Override
    public ResponseEntity<APIResponse> getProducts() {
        if (productRepository.findAll().isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "No product found", ""), HttpStatus.NOT_FOUND);
        }
        List<ProductResponse> productResponses = productRepository.findAll().stream()
        .map(ResponseConverter::convertToProductResponse)
        .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
}
    @Override
    public ResponseEntity<APIResponse> getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Product not found", ""), HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        ProductResponse productResponse = ResponseConverter.convertToProductResponse(product);
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponse), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> getProductsByCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Category not found", ""), HttpStatus.NOT_FOUND);
        }
        Category category = categoryOptional.get();
        List<ProductResponse> productResponses = category.getProducts().stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<APIResponse> getProductsByColor(Long colorId) {
        Optional<ColorProduct> colorProductOptional = colorRepository.findById(colorId);
        if (colorProductOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Color not found", ""), HttpStatus.NOT_FOUND);
        }
        ColorProduct colorProduct = colorProductOptional.get();
        List<ProductResponse> productResponses = colorProduct.getProducts().stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> getProductsBySize(Long sizeId) {
        Optional<Size> sizeOptional = sizeRepository.findById(sizeId);
        if (sizeOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Size not found", ""), HttpStatus.NOT_FOUND);
        }
        Size size = sizeOptional.get();
        List<ProductResponse> productResponses = size.getProducts().stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<APIResponse> getProductsByPriceRangeAsc(Double minPrice, Double maxPrice) {
        List<Product> products = productRepository.findProductsByPriceRangeAsc(minPrice, maxPrice);
        if (products.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "No products found in the specified price range", ""), HttpStatus.NOT_FOUND);
        }
        List<ProductResponse> productResponses = products.stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> getProductsByPriceRangeDesc(Double minPrice, Double maxPrice) {
        List<Product> products = productRepository.findProductsByPriceRangeDesc(minPrice, maxPrice);
        if (products.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "No products found in the specified price range", ""), HttpStatus.NOT_FOUND);
        }
        List<ProductResponse> productResponses = products.stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> getProductsByStyle(Long styleId) {
        Optional<StyleProduct> styleProductOptional = styleRepository.findById(styleId);
        if (styleProductOptional.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "Style not found", ""), HttpStatus.NOT_FOUND);
        }
        StyleProduct styleProduct = styleProductOptional.get();
        List<ProductResponse> productResponses = styleProduct.getProducts().stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> getProductsByMultipleFilters(Long categoryId, Long colorId, Long sizeId, Long styleId, Double minPrice, Double maxPrice) {
        List<Product> products = productRepository.findProductsByMultipleFilters(categoryId, colorId, sizeId, styleId, minPrice, maxPrice);
        if (products.isEmpty()) {
            return new ResponseEntity<>(new APIResponse(false, "No products found with the specified filters", ""), HttpStatus.NOT_FOUND);
        }
        List<ProductResponse> productResponses = products.stream()
                .map(ResponseConverter::convertToProductResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new APIResponse(true, "Success", productResponses), HttpStatus.OK);
    }


}