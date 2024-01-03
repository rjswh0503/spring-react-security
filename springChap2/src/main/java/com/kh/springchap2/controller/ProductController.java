package com.kh.springchap2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springchap2.model.Product;
import com.kh.springchap2.repository.ProductRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= "http://localhost:3000", allowCredentials ="true")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	@GetMapping("/item")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return ResponseEntity.ok(products);
	}
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProduct(@RequestBody Product newProduct ) {
		Product createProduct = productRepository.save(newProduct);
		return ResponseEntity.ok(createProduct);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productRepository.deleteById(id);
		return ResponseEntity.ok("성공적으로 삭제했습니다.");
		
		
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,
					@RequestBody Product updatedProduct){
		Product existProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("아이디를 찾을 수 없음" + id));
		existProduct.setName(updatedProduct.getName());
		existProduct.setPrice(updatedProduct.getPrice());
		
		Product updateProduct = productRepository.save(existProduct);
		return ResponseEntity.ok(updateProduct);
	

	}
	
	

}
