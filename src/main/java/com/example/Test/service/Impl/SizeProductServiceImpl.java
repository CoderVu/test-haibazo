package com.example.Test.service.Impl;

import com.example.Test.model.Product;
import com.example.Test.model.Size;
import com.example.Test.repository.ProductRepository;
import com.example.Test.repository.SizeRepository;
import com.example.Test.request.SizeProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.SizeProductResponse;
import com.example.Test.service.ISizeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SizeProductServiceImpl  implements ISizeProductService{
    @Autowired
    private final SizeRepository sizeRepository;
    @Autowired
    private final ProductRepository productRepository;

    public SizeProductServiceImpl(SizeRepository sizeRepository, ProductRepository productRepository) {
        this.sizeRepository = sizeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addSize(SizeProductRequest sizeProductRequest) {
        Size sizeProduct = new Size();
        sizeProduct.setName(sizeProductRequest.getSize());
        sizeRepository.save(sizeProduct);
        return ResponseEntity.ok(new APIResponse(true, "Add to size successfully", ""));

    }
    @Override
    public ResponseEntity<APIResponse> addSizeToProduct(Long productId, Long sizeId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        Product product = productOptional.get();
        Optional<Size> sizeProductOptional = sizeRepository.findById(sizeId);
        if (!sizeProductOptional.isPresent()) {
            return ResponseEntity.ok(new APIResponse(false, "Size not found", ""));
        }
        Size sizeProduct = sizeProductOptional.get();
        List<Size> sizes = product.getSizes();
        if (sizes == null) {
            sizes = new ArrayList<>();
        }
        if (sizes.contains(sizeProduct)) {
            return ResponseEntity.ok(new APIResponse(false, "Size already added to product", ""));
        }
        sizes.add(sizeProduct);
        product.setSizes(sizes);
        List<Product> products = sizeProduct.getProducts();
        if (products == null) {
            products = new ArrayList<>();
        }
        if (!products.contains(product)) {
            products.add(product);
        }
        sizeProduct.setProducts(products);
        productRepository.save(product);
        sizeRepository.save(sizeProduct);
        return ResponseEntity.ok(new APIResponse(true, "Add size to product successfully", ""));
    }
    @Override
    public ResponseEntity<APIResponse> getSizesByProductId(Long productId) {
        List<Size> sizeProducts = sizeRepository.findByProductId(productId);
        List<SizeProductResponse> sizeProductResponses = sizeProducts.stream()
                .map(sizeProduct -> new SizeProductResponse(sizeProduct.getSizeId(), sizeProduct.getName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse(true, "Get size by product id successfully", sizeProductResponses));

    }

}
