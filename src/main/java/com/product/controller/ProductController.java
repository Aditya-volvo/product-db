package com.product.controller;

import com.product.dto.ResponseProduct;
import com.product.dto.ResquestProdut;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@RequestBody  ResquestProdut resquestProdut){
        productService.addProduct(resquestProdut);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseProduct> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseProduct getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@PathVariable Long productId){
        productService.deleteProductById(productId);
    }

}
