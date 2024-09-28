package com.example.Test.response;

import com.example.Test.model.Category;
import com.example.Test.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseConverter {
    public static double calculateAverageRate(List<RateProductResponse> rates) {
        if (rates == null || rates.isEmpty()) {
            return 0.0;
        }
        double totalRate = 0.0;
        for (RateProductResponse rate : rates) {
            totalRate += rate.getRate();
        }
        return totalRate / rates.size();
    }

    public static ProductResponse convertToProductResponse(Product product) {
        List<CategoryResponse> categoryResponses = product.getCategories().stream()
                .map(category -> new CategoryResponse(
                        category.getCategoryId(),
                        category.getCategoryName())
                ).collect(Collectors.toList());

        List<ImageProductResponse> imageProductResponses = product.getImageProducts().stream()
                .map(imageProduct -> new ImageProductResponse(imageProduct.getImageId(), imageProduct.getImage()))
                .collect(Collectors.toList());

        List<ColorProductResponse> colorProductResponses = product.getColorProducts().stream()
                .map(colorProduct -> new ColorProductResponse(colorProduct.getColorProductId(), colorProduct.getColor()))
                .collect(Collectors.toList());

        List<SizeProductResponse> sizeProductResponses = product.getSizes().stream()
                .map(sizeProduct -> new SizeProductResponse(sizeProduct.getSizeId(), sizeProduct.getName()))
                .collect(Collectors.toList());

        List<StyleProductResponse> styleProductResponses = product.getStyleProducts().stream()
                .map(styleProduct -> new StyleProductResponse(styleProduct.getStyleProductId(), styleProduct.getStyle()))
                .collect(Collectors.toList());
        List<RateProductResponse> rateProductResponses = product.getRates().stream()
                .map(rateProduct -> new RateProductResponse(rateProduct.getRateId(), rateProduct.getRate(), rateProduct.getComment()))
                .collect(Collectors.toList());
        double averageRate = calculateAverageRate(rateProductResponses);
        return new ProductResponse(
                product.getProductId(),
                product.getProductName(),
                product.getDescription(),
                product.getProductPrice(),
                product.getViews(),
                averageRate,
                product.getDiscountPrice(),
                product.getExpiredPromotion(),
                categoryResponses,
                imageProductResponses,
                colorProductResponses,
                sizeProductResponses,
                styleProductResponses,
                rateProductResponses
        );
    }

    public static CategoryResponse convertToCategoryResponse(Category category) {
        return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
    }

}
