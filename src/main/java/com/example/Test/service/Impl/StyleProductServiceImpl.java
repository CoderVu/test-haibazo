package com.example.Test.service.Impl;

import com.example.Test.model.Product;
import com.example.Test.model.StyleProduct;
import com.example.Test.repository.ProductRepository;
import com.example.Test.repository.StyleProductRepository;
import com.example.Test.request.StyleRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.StyleProductResponse;
import com.example.Test.service.IStyleProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StyleProductServiceImpl implements IStyleProductService {
    @Autowired
    private final StyleProductRepository styleProductRepository;
    @Autowired
    private final ProductRepository productRepository;

    public StyleProductServiceImpl(StyleProductRepository styleProductRepository, ProductRepository productRepository) {
        this.styleProductRepository = styleProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addStyle(StyleRequest styleRequest) {
        StyleProduct styleProduct = new StyleProduct();
        styleProduct.setStyle(styleRequest.getName());
        styleProductRepository.save(styleProduct);
        return ResponseEntity.ok(new APIResponse(true, "Add to style successfully", ""));
    }
    @Override
    public ResponseEntity<APIResponse> addStyleToProduct(Long productId, Long styleId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        Product product = productOptional.get();
        Optional<StyleProduct> styleProductOptional = styleProductRepository.findById(styleId);
        if (!styleProductOptional.isPresent()) {
            return ResponseEntity.ok(new APIResponse(false, "Style not found", ""));
        }
        StyleProduct styleProduct = styleProductOptional.get();
        List<StyleProduct> styles = product.getStyleProducts();
        if (styles == null) {
            styles =  new ArrayList<>();
        }
        if (styles.contains(styleProduct)) {
            return ResponseEntity.ok(new APIResponse(false, "Style already added to product", ""));
        }
        styles.add(styleProduct);
        product.setStyleProducts(styles);
        List<Product> products = styleProduct.getProducts();
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        styleProduct.setProducts(products);
        productRepository.save(product);
        styleProductRepository.save(styleProduct);

        return ResponseEntity.ok(new APIResponse(true, "Add style to product successfully", ""));
    }
    @Override
    public ResponseEntity<APIResponse> getStylesByProductId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        List<StyleProduct> styleProducts = styleProductRepository.findByProductId(productId);
        List<StyleProductResponse> styleResponses = styleProducts.stream()
                .map(style -> new StyleProductResponse(style.getStyleProductId(), style.getStyle()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse(true, "Styles fetched successfully", styleResponses));
    }
}
