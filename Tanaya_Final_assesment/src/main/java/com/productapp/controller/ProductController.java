package com.productapp.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//--------method was giving u all products----------
	@GetMapping(path = "products")
	public List<Product> getAll(){
		
		return productService.getAll();
	}
	
	//--------get a specific product-------
	@GetMapping(path = "products/{id}")
	public Product getOneProduct(@PathVariable int id){
		return productService.getById(id);
	}
	
	//--------add a product-------
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@Valid  @RequestBody Product product) {
		Product product2=productService.add(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product2);
	}
	
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
		Product product2=productService.update(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(product2);
	}
	
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		Product productDeleted= productService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}






