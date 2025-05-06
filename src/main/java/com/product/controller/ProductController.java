package com.product.controller;

import com.product.dto.ResquestProdut;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
