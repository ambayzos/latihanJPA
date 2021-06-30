package com.example.latihanjpadua.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihanjpadua.entity.Product;
import com.example.latihanjpadua.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> findAllProducts(){
		return productService.listallProduct();
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id){
		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
//	@PutMapping("/update/{id}")
//	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id){
//		try {
//			Product exitProduct = productService.getProduct(id);
//			product.setId(id);
//			productService.saveProduct(product);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			// TODO: handle exception
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
