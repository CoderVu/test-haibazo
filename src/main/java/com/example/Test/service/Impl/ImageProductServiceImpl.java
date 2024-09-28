package com.example.Test.service.Impl;

import com.example.Test.model.ImageProduct;
import com.example.Test.model.Product;
import com.example.Test.repository.ImageProductRepository;
import com.example.Test.repository.ProductRepository;
import com.example.Test.request.ImageProductRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.ImageProductResponse;
import com.example.Test.service.IImageProductService;
import com.example.Test.utils.ImageGeneral;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ImageProductServiceImpl implements IImageProductService {
    @Autowired
    private final ImageProductRepository imageProductRepository;
    @Autowired
    private final ProductRepository productRepository;

    public ImageProductServiceImpl(ImageProductRepository imageProductRepository, ProductRepository productRepository) {
        this.imageProductRepository = imageProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addImageProduct(ImageProductRequest imageProductRequest) {
        ImageProduct imageProduct = new ImageProduct();
        try {
            InputStream imageInputStream = imageProductRequest.getImage().getInputStream();
            String base64Image = ImageGeneral.fileToBase64(imageInputStream);
            imageProduct.setImage(base64Image);
        } catch (IOException e) {
            return new ResponseEntity<>(new APIResponse(false, "Error when upload image", ""), HttpStatus.BAD_REQUEST);
        }
        try {
            Product product = productRepository.findById(imageProductRequest.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            imageProduct.setProduct(product);
        } catch (Exception e) {
            return new ResponseEntity<>(new APIResponse(false, "Product not found", ""), HttpStatus.BAD_REQUEST);
        }
        imageProductRepository.save(imageProduct);
        return ResponseEntity.ok(new APIResponse(true, "Add to image successfully", ""));
    }

    @Override
    public ResponseEntity<APIResponse> getImagesByProductId(Long productId) {

        List<ImageProduct> imageProducts = imageProductRepository.findByProductId(productId);
        List<ImageProductResponse> imageProductResponses = imageProducts.stream().map(imageProduct -> {
            ImageProductResponse imageProductResponse = new ImageProductResponse(imageProduct.getImageId(), imageProduct.getImage());
            imageProductResponse.setImage(imageProduct.getImage());
            imageProductResponse.setImage(imageProduct.getImage());
            return imageProductResponse;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(new APIResponse(true, "Get images successfully", imageProductResponses));
    }
}