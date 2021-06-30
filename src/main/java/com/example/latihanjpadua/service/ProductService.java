package com.example.latihanjpadua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.latihanjpadua.entity.Product;
import com.example.latihanjpadua.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> listallProduct(){
		return productRepository.findAll();
	}
	
	public Product getProduct(Integer id) {
		return productRepository.findById(id).get();
	}
	
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product deleted";
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		return productRepository.save(existingProduct);
	}
}
