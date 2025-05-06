package com.product.service.serviceimpl;

import com.product.dto.ResponseProduct;
import com.product.dto.ResquestProdut;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public void addProduct(ResquestProdut resquestProdut) {
        Product product = Product.builder()
                .productName(resquestProdut.getProductName())
                .productPrice(resquestProdut.getProductPrice())
                .productQuantity(resquestProdut.getProductQuantity())
                .build();
        productRepository.save(product);
        log.info("Product {} is Saved",product.getProductId());
    }

    @Override
    public List<ResponseProduct> getAllProduct() {
        List<Product> product=productRepository.findAll();
        return product.stream().map(this::mapToResponseProduct).toList();
    }

    private ResponseProduct mapToResponseProduct(Product product) {
        return    ResponseProduct.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .build();
    }
}
