package com.product.service.serviceimpl;

import com.product.dto.ResponseProduct;
import com.product.dto.ResquestProdut;
import com.product.exception.IdNotFoundException;
import com.product.mapper.ProductMapper;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
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
        return product.stream().map(productMapper::mapToResponseProduct).toList();
    }

    @Override
    public ResponseProduct getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new IdNotFoundException("Product id"+productId+" not found"));
        return productMapper.mapToResponseProduct(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new IdNotFoundException("Product Id"+productId+"not present"));
        productRepository.delete(product);
        log.info("Product {} is deleted",productId);
    }


}
