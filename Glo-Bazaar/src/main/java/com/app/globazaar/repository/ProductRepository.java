package com.app.globazaar.repository;


import com.app.globazaar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
}