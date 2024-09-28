package com.example.Test.service.Impl;

import com.example.Test.model.Product;
import com.example.Test.model.Rate;
import com.example.Test.repository.ProductRepository;
import com.example.Test.repository.RateRepository;
import com.example.Test.request.RateRequest;
import com.example.Test.response.APIResponse;
import com.example.Test.response.RateProductResponse;
import com.example.Test.service.IRatingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements IRatingService {
    @Autowired
    private final RateRepository ratingRepository;
    @Autowired
    private final ProductRepository productRepository;

    public RatingServiceImpl(RateRepository ratingRepository, ProductRepository productRepository) {
        this.ratingRepository = ratingRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<APIResponse> addRating(RateRequest rateRequest) {
        Product product = productRepository.findById(rateRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Rate rate = new Rate();
        rate.setProduct(product);
        rate.setRate(rateRequest.getRate());
        rate.setComment(rateRequest.getComment());
        ratingRepository.save(rate);
        return ResponseEntity.ok(new APIResponse(true, "Rating added successfully", ""));
    }

    @Override
    public ResponseEntity<APIResponse> getRatingsByProductId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            return ResponseEntity.ok(new APIResponse(false, "Product not found", ""));
        }
        List<Rate> rates = ratingRepository.findByProductId(productId);
        List<RateProductResponse> rateResponses = rates.stream()
                .map(rate -> new RateProductResponse(rate.getProduct().getProductId(), rate.getRate(), rate.getComment()))
                .toList();
        return ResponseEntity.ok(new APIResponse(true, "Ratings fetched successfully", rateResponses));
    }

}
