package com.product.mapper;

import com.product.dto.ResponseProduct;
import com.product.model.Product;

public class ProductMapper {
    public ResponseProduct mapToResponseProduct(Product product) {
        return    ResponseProduct.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .build();
    }
}
