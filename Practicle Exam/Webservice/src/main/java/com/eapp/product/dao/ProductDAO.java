package com.eapp.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.eapp.product.Products;
import com.eapp.product.repository.ProductRepository;

@Service
public class ProductDAO {
	@Autowired ProductRepository productRepository;
	/* SAVE A PRODUCTS */ 
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED) 
	public Products save(Products p) { return  productRepository .save(p);
	}
	/* SEARCH ALL PRODUCTS */
	public List<Products> findAll(){ 
		return productRepository.findAll();
	} /* GET A PRODUCTS */
	public Products findOne(Long pId) {
		Optional<Products> op = productRepository.findById(pId);
		if(op.isPresent()){ 
		return op.get();
	}
	else { 
		return null; 
		} 
	}
	/* DELETE A PRODUCTS by id */ 
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public void delete(Products p) {
		productRepository.delete(p);
	}
}
