package com.app.globazaar.service.impl;

import com.app.globazaar.dto.ProductDto;
import com.app.globazaar.entity.Product;
import com.app.globazaar.entity.User;
import com.app.globazaar.exception.GloBazaarApiException;
import com.app.globazaar.exception.ResourceNotFoundException;
import com.app.globazaar.repository.ProductRepository;
import com.app.globazaar.repository.UserRepository;
import com.app.globazaar.service.ProductService;
import com.app.globazaar.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    // This method is used to add a product to a user
    @Override
    public ProductDto addProduct(ProductDto productDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Product product = Mapper.mapToProductEntity(productDto);
        product.setUser(user);
        Product savedProduct = productRepository.save(product);
        return Mapper.mapToProductDto(savedProduct);
    }

    // This method is used to get a product by productId
    @Override
    public ProductDto getProductById(Long userId, Long productId) {
        // check whether user is valid or not by userId
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", productId));
        // fetch the product by productId
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        // check whether the product belongs to the user or not
        if(!product.getUser().getId().equals(userId)){
            throw new GloBazaarApiException(HttpStatus.BAD_REQUEST,"You are not authorized to access this product");
        }
        return Mapper.mapToProductDto(product);
    }
}