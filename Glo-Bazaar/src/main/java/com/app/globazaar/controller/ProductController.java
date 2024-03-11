package com.app.globazaar.controller;

import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a product to a user
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(
            @PathVariable Long userId,
            @Valid @RequestBody ProductDto productDto
    ) {
        return new ResponseEntity<>(productService.addProduct(productDto, userId), HttpStatus.CREATED);
    }

    // Get a product by productId
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        return new ResponseEntity<>(productService.getProductById(userId, productId), HttpStatus.OK);
    }

}