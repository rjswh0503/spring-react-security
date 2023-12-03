package com.kh.springchap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springchap2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
