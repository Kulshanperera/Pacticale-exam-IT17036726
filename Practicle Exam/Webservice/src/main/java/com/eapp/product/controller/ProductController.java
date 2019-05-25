package com.eapp.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapp.product.Products;
import com.eapp.product.dao.ProductDAO;

@RestController 
@RequestMapping("/company")
public class ProductController {
	@Autowired ProductDAO productDAO;
	/* SAVE A PRODUCT */ 
	@PostMapping("/products") 
	public Products createProduct(@Valid @RequestBody Products p) { 
		return productDAO.save(p);
	}
	/* Get PRODUCT BY ID */
	@GetMapping("/products") 
	public List<Products> getAllProducts(){ return productDAO.findAll();
	}
	/* UPDATE A PRODUCT BY ID */
	@GetMapping("/products/{id}")
	public ResponseEntity< Products> getProductsById(@PathVariable(value="id") Long pId){ 
		 Products p = productDAO.findOne(pId);
	if(p==null) {
		return ResponseEntity.notFound().build();
	} 
	return ResponseEntity.ok().body(p);
	} 
	/* UPDATE A PRODUCT BY ID */
	@PutMapping("/products/{id}") 
	public ResponseEntity< Products> updateProduct(@PathVariable(value="id") Long pId,
	@Valid
	@RequestBody  Products pDetails){ 
		 Products p=productDAO.findOne(pId);
	if(p==null) { 
		return ResponseEntity.notFound().build();
	}
	p.setName(pDetails.getName());
	p.setPrice(pDetails.getPrice());
	p.setDescription(pDetails.getDescription());
	Products updaProduct=productDAO.save(p);
	return ResponseEntity.ok().body(updaProduct);
	}
	/*DELETE A PRODUCT*/
	@DeleteMapping("/products/{id}") 
	public ResponseEntity< Products> deleteProdutc(@PathVariable(value="id") Long pId){ 
		 Products p = productDAO.findOne(pId); 
		if(p==null) { 
			return ResponseEntity.notFound().build();
	}
	productDAO.delete(p);
	return ResponseEntity.ok().build();
	}
}
