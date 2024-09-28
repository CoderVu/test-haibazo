package com.example.Test.service.Impl;

import com.example.Test.model.ColorProduct;
import com.example.Test.model.Product;
import com.example.Test.repository.ColorProductRepository;
import com.example.Test.repository.ProductRepository;
import com.example.Test.request.ColorProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.ColorProductResponse;
import com.example.Test.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ColorServiceImpl implements IColorService {
    @Autowired
    private final ColorProductRepository colorRepository;
    @Autowired
    private final ProductRepository productRepository;

    public ColorServiceImpl(ColorProductRepository colorRepository, ProductRepository productRepository) {
        this.colorRepository = colorRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<APIResponse> addColor(ColorProductRequest colorProductRequest) {
        ColorProduct colorProduct = new ColorProduct();
        colorProduct.setColor(colorProductRequest.getName());
        colorRepository.save(colorProduct);
        return ResponseEntity.ok(new APIResponse(true, "Add to color successfully", ""));

    }
    @Override
    public ResponseEntity<APIResponse> addColorToProduct(Long productId, Long colorId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        Product product = productOptional.get();
        Optional<ColorProduct> colorProductOptional = colorRepository.findById(colorId);
        if (colorProductOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Color not found", ""));
        }
        ColorProduct colorProduct = colorProductOptional.get();
        List<ColorProduct> colors = product.getColorProducts();
        if (colors == null) {
            colors = new java.util.ArrayList<>();
        }
        if (colors.contains(colorProduct)) {
            return ResponseEntity.ok(new APIResponse(false, "Color already added to product", ""));
        }
        colors.add(colorProduct);
        product.setColorProducts(colors);
        productRepository.save(product);
        return ResponseEntity.ok(new APIResponse(true, "Add color to product successfully", ""));
    }
    @Override
    public ResponseEntity<APIResponse> getColorsByProductId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        List<ColorProduct> colorProducts = colorRepository.findByProductId(productId);
        List<ColorProductResponse> colorProductResponses = colorProducts.stream()
                .map(colorProduct -> new ColorProductResponse(colorProduct.getColorProductId(), colorProduct.getColor()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse(true, "Get color by product id successfully", colorProductResponses));

    }
}
