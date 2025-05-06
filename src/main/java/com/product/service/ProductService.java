package com.product.service;

import com.product.dto.ResponseProduct;
import com.product.dto.ResquestProdut;

import java.util.List;

public interface ProductService {
    void addProduct(ResquestProdut resquestProdut);

    List<ResponseProduct> getAllProduct();

    ResponseProduct getProductById(Long productId);

    void deleteProductById(Long productId);
}
