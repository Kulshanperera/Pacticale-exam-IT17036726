package com.eapp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eapp.product.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
