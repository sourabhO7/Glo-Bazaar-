package com.app.globazaar.service;

import com.app.globazaar.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDTO, Long userId);
    ProductDto getProductById(Long userId, Long productId);
}
