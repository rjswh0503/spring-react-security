package com.kh.springchap3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springchap3.mapper.ProductMapper;
import com.kh.springchap3.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	
	
	public List<Product> getAllProduct() {
		return productMapper.getAllProduct();
	}
	
	


	public void addProduct(Product product) {
		productMapper.insertProduct(product);
	}
	
	
	
	
	

}
